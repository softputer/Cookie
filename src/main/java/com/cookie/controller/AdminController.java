package com.cookie.controller;

import com.cookie.service.CommodityService;
import com.cookie.service.UserService;
import com.cookie.serviceImpl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by koko on 19.08.16.
 */
@Controller
public class AdminController {

    @Autowired
    private AdminServiceImpl adminService;


    @RequestMapping("/admin")
    public String adminPage(Model model) {
        model.addAttribute("users", adminService.getAllUsersWithCommodities());
        return "admin";
    }

    @RequestMapping("/delete/{id_user}/{id_commodity}")
    public String delete(@PathVariable String id_user, @PathVariable String id_commodity) {
        adminService.deleteOrder(Integer.parseInt(id_user), Integer.parseInt(id_commodity));
        return "redirect:/";
    }


}
