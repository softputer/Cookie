package com.cookie.serviceImpl;

import com.cookie.entity.Shop;
import com.cookie.repository.ShopRepository;
import com.cookie.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by koko on 19.08.16.
 */
@Service
public class ShopServiceImpl implements ShopService{
    @Autowired
    private ShopRepository shopRepository;

    @Override
    public void save(Shop shop) {
        shopRepository.save(shop);
    }

    @Override
    public List<Shop> findAll() {
        return shopRepository.findAll();
    }

    @Override
    public Shop findOne(int id) {
        return shopRepository.findOne(id);
    }

    @Override
    public void delete(int id) {
        shopRepository.delete(id);
    }

}
