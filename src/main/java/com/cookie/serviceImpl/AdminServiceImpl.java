package com.cookie.serviceImpl;

import com.cookie.entity.Commodity;
import com.cookie.entity.User;
import com.cookie.service.CommodityService;
import com.cookie.service.UserService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by koko on 19.08.16.
 */
@Service
public class AdminServiceImpl {

    @Autowired
    private CommodityService commodityService;
    @Autowired
    private UserService userService;

    public List<User> getAllUsersWithCommodities(){
        return userService.selectFetchUser();
    }

    @Transactional
    public void deleteOrder(int user_id, int id_commodity){
        User user = userService.findOne(user_id);
        Hibernate.initialize(user);
        Commodity commodity = commodityService.findOne(user_id);
        user.getCommodities().remove(commodity);
    }


}
