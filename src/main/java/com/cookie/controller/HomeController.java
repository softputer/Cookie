package com.cookie.controller;

import com.cookie.service.CommodityService;
import com.cookie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by koko on 17.08.16.
 */
@Controller
public class HomeController {

    @Autowired
    private CommodityService commodityService;


//    @RequestMapping("/")
//    public String home(@CookieValue(value = "hitCounter", defaultValue = "0") int hitCounter,
//                       HttpServletResponse response, HttpServletRequest request){
//
//        hitCounter++;
//        Cookie cookie = new Cookie("hitCounter", String.valueOf(hitCounter));
//        response.addCookie(cookie);
//
//        System.out.println(request.getCookies());
//
//
//        return "home";
//    }

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("commodities", commodityService.findAll());
        return "home";
    }

//    @RequestMapping(value = "/cookie", method = RequestMethod.POST)
//    public String getCookie(HttpServletRequest request, HttpServletResponse response, @RequestParam String cookie, Model model) {
//        response.addCookie(new Cookie("one", cookie));
//        Cookie cookie1 = new Cookie("sad","asda");
//
//        for (Cookie cooki : request.getCookies()) {
//            System.out.println(cooki.getName());
//            System.out.println(cooki.getValue());
//        }
//        return "redirect:/";
//    }
}
