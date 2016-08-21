package com.cookie.controller;

import com.cookie.entity.Commodity;
import com.cookie.service.CommodityService;
import com.cookie.service.ShopService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by koko on 17.08.16.
 */
@Controller
public class CommodityController {

    @Autowired
    private CommodityService commodityService;
    @Autowired
    private ShopService shopService;

    @RequestMapping(value = "/newCommodity",method = RequestMethod.GET)
    public String newCommodity(Model model){
        model.addAttribute("commodity", new Commodity());
        model.addAttribute("shops", shopService.findAll());
        return "newCommodity";
    }

    @RequestMapping(value = "/newCommodity",method = RequestMethod.POST)
    public String newCommodity(@ModelAttribute Commodity commodity, @RequestParam String shop_id){
        Hibernate.initialize(commodity);
        commodity.getShops().add(shopService.findOne(Integer.parseInt(shop_id)));
        commodityService.save(commodity);
        return "redirect:/";
    }

    @RequestMapping(value = "/deleteCommodity/{id}",method = RequestMethod.GET)
    public String deleteCommodity(@PathVariable String id){
        commodityService.delete(Integer.parseInt(id));
        return "redirect:/";
    }





}
