package com.cookie.service;

import com.cookie.entity.Commodity;

import java.util.List;

/**
 * Created by koko on 17.08.16.
 */
public interface CommodityService {
    void save(Commodity commodity);
    List<Commodity> findAll();
    Commodity findOne(int id);
    void delete(int id);
    List<Commodity> selectFetchShop();
}
