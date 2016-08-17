package com.cookie.serviceImpl;

import com.cookie.entity.Commodity;
import com.cookie.repository.CommodityRepository;
import com.cookie.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by koko on 17.08.16.
 */
@Service
public class CommodityServiceImpl implements CommodityService {
    @Autowired
    private CommodityRepository commodityRepository;

    @Override
    public void save(Commodity commodity) {
        commodityRepository.save(commodity);
    }

    @Override
    public List<Commodity> findAll() {
        return commodityRepository.findAll();
    }

    @Override
    public Commodity findOne(int id) {
        return commodityRepository.findOne(id);
    }

    @Override
    public void delete(int id) {
        commodityRepository.delete(id);
    }
}
