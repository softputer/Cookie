package com.cookie.serviceImpl;

import com.cookie.entity.Commodity;
import com.cookie.entity.User;
import com.cookie.service.CommodityService;
import com.cookie.service.UserService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by koko on 20.08.16.
 */
@Service
public class ProfileServiceImpl {
    @Autowired
    private UserService userService;
    @Autowired
    private CommodityService commodityService;

    public List<Commodity> basket(HttpServletRequest request) {
        request.getSession(false);
        ArrayList<Commodity> commodities = new ArrayList<>();
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("JSESSIONID")) {
            } else {
                commodities.add(commodityService.findOne(Integer.parseInt(cookie.getValue())));
            }
        }
        return commodities;

    }

    public Cookie intoBasket(int id, HttpServletRequest request, HttpServletResponse response) {
        request.getSession(false);
        Commodity commodity = commodityService.findOne(id);

        Cookie cookieCommodity = new Cookie(commodity.getName(), String.valueOf(commodity.getId()));
        cookieCommodity.setMaxAge(24 * 60 * 60 * 60);
        cookieCommodity.setHttpOnly(true);
        cookieCommodity.setPath("/");
        return cookieCommodity;
    }
    @Transactional
    public void getOrder(Principal principal, String id, HttpServletRequest request,
                         HttpServletResponse response) {
        User user = userService.findOne(Integer.parseInt(principal.getName()));
        Commodity commodity = commodityService.findOne(Integer.parseInt(id));
        Hibernate.initialize(user.getCommodities());
        user.getCommodities().add(commodity);

        Cookie[] cookies = request.getCookies();
        sortCookie(cookies, id, response);

    }

    public void deleteCookie(String id, HttpServletRequest request,
                             HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        sortCookie(cookies, id, response);
    }


    public void sortCookie(Cookie[] cookies, String id, HttpServletResponse response) {
        for (int i = 0; i < cookies.length; i++) {
            if (id.equals(cookies[i].getValue())) {
                Cookie cookie = new Cookie(cookies[i].getName(), null);
                cookie.setPath("/");
                cookie.setValue(null);
                cookie.setHttpOnly(true);
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }

    }


}
