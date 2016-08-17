package com.cookie.controller;

import com.cookie.entity.Commodity;
import com.cookie.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by koko on 17.08.16.
 */
@Controller
public class CommodityController {

    @Autowired
    private CommodityService commodityService;

    @RequestMapping(value = "/newCommodity",method = RequestMethod.GET)
    public String newCommodity(Model model){
        model.addAttribute("commodity", new Commodity());
        return "newCommodity";
    }

    @RequestMapping(value = "/newCommodity",method = RequestMethod.POST)
    public String newCommodity(@ModelAttribute Commodity commodity){
        commodityService.save(commodity);
        return "redirect:/";
    }





}
