package com.cookie.controller;

import com.cookie.entity.User;
import com.cookie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.security.Principal;

/**
 * Created by koko on 17.08.16.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute User user) {
        userService.save(user);
        return "home";
    }

    @RequestMapping("/loginpage")
    public String login() {
        return "loginpage";
    }

    @RequestMapping(value = "/sendImage", method = RequestMethod.POST)
    public String saveImage(@RequestParam("image") MultipartFile multipartFile,
                            Principal principal) {

        userService.usersetImage(multipartFile, principal);
        return "home";

    }


}
