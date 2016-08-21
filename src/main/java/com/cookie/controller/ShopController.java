package com.cookie.controller;

import com.cookie.entity.Shop;
import com.cookie.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by koko on 19.08.16.
 */
@Controller
public class ShopController {
    @Autowired
    private ShopService shopService;

    @RequestMapping(value = "/newShop",method = RequestMethod.GET)
    public String newShop(Model model){
        model.addAttribute("shop", new Shop());
        return "newShop";
    }

    @RequestMapping(value = "/newShop",method = RequestMethod.POST)
    public String newShop(@ModelAttribute Shop shop){
        shopService.save(shop);
        return "redirect:/";
    }

    @RequestMapping(value = "/deleteShop/{id}")
    public String deleteShop(@PathVariable String id){
        shopService.delete(Integer.parseInt(id));
        return "redirect:/";
    }


}
