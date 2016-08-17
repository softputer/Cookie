package com.cookie.controller;

import com.cookie.entity.Commodity;
import com.cookie.entity.User;
import com.cookie.service.CommodityService;
import com.cookie.service.UserService;
import com.sun.deploy.net.HttpResponse;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by koko on 17.08.16.
 */
@Controller
public class BasketController {

    @Autowired
    private UserService userService;
    @Autowired
    private CommodityService commodityService;

    @RequestMapping(value = "/addIntoBasket", method = RequestMethod.GET)
    public String basket(HttpServletRequest request, Model model) {
        request.getSession(false);
        ArrayList<Commodity> commodities = new ArrayList<>();
        for(Cookie cookie : request.getCookies()){
            if (cookie.getName().equals("JSESSIONID")) {
            } else {
                commodities.add(commodityService.findOne(Integer.parseInt(cookie.getValue())));
            }
        }
        model.addAttribute("commodities", commodities);
        return "basket";
    }

    @RequestMapping(value = "/intoBasket/{id}", method = RequestMethod.GET)
    public String intoBasket(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) {
        request.getSession(false);
        Commodity commodity = commodityService.findOne(Integer.parseInt(id));

        Cookie cookieCommodity = new Cookie(commodity.getName(), String.valueOf(commodity.getId()));
        cookieCommodity.setMaxAge(24 * 60 * 60* 60);
        cookieCommodity.setHttpOnly(true);
        cookieCommodity.setPath("/");
        response.addCookie(cookieCommodity);
        return "redirect:/";
    }
    @Transactional
    @RequestMapping(value = "/getOrder/{id}", method = RequestMethod.GET)
    public String getOrder(Principal principal, @PathVariable String id, HttpServletRequest request,
                           HttpServletResponse response){
        User user = userService.findOne(Integer.parseInt(principal.getName()));
        Commodity commodity = commodityService.findOne(Integer.parseInt(id));
        Hibernate.initialize(user.getCommodities());
        user.getCommodities().add(commodity);
        
        Cookie [] cookies = request.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            if(id.equals(cookies[i].getValue())){
                Cookie cookie = new Cookie(cookies[i].getName(), null);
                cookie.setPath("/");
                cookie.setValue(null);
                cookie.setHttpOnly(true);
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }

        return "redirect:/addIntoBasket";
    }

    @RequestMapping(value = "/deleteCookie/{id}",method = RequestMethod.GET)
    public String deleteCookie(@PathVariable String id,HttpServletRequest request,
                               HttpServletResponse response){
        Cookie [] cookies = request.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            if(id.equals(cookies[i].getValue())){
                Cookie cookie = new Cookie(cookies[i].getName(), null);
                cookie.setPath("/");
                cookie.setValue(null);
                cookie.setHttpOnly(true);
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
        return "redirect:/addIntoBasket";
    }


}
