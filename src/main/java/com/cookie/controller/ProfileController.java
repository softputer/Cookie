package com.cookie.controller;

import com.cookie.entity.User;
import com.cookie.service.CommodityService;
import com.cookie.service.UserService;
import com.cookie.serviceImpl.ProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

/**
 * Created by koko on 17.08.16.
 */
@Controller
public class ProfileController {

    @Autowired
    private UserService userService;
    @Autowired
    private CommodityService commodityService;
    @Autowired
    private ProfileServiceImpl basketService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String basket(HttpServletRequest request, Model model, Principal principal) {
        User user = userService.findOne(Integer.parseInt(principal.getName()));
        user.setAvatar(user.getAvatar().substring(43));
        model.addAttribute("user",user);
        model.addAttribute("commodities", basketService.basket(request));
        return "profile";
    }

    @RequestMapping(value = "/intoBasket/{id}", method = RequestMethod.GET)
    public String intoBasket(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) {

        response.addCookie(basketService.intoBasket(Integer.parseInt(id), request, response));

        return "redirect:/profile";
    }


    @RequestMapping(value = "/getOrder/{id}", method = RequestMethod.GET)
    public String getOrder(Principal principal, @PathVariable String id, HttpServletRequest request,
                           HttpServletResponse response) {

        basketService.getOrder(principal, id, request, response);

        return "redirect:/profile";
    }

    @RequestMapping(value = "/deleteCookie/{id}", method = RequestMethod.GET)
    public String deleteCookie(@PathVariable String id, HttpServletRequest request,
                               HttpServletResponse response) {

        basketService.deleteCookie(id, request, response);

        return "redirect:/profile";
    }




}
