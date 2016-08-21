package com.cookie.service;

import com.cookie.entity.Shop;

import java.util.List;

/**
 * Created by koko on 19.08.16.
 */
public interface ShopService {

    void save(Shop shop);
    List<Shop> findAll();
    Shop findOne(int id);
    void delete(int id);

}
