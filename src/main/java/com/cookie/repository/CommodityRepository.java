package com.cookie.repository;

import com.cookie.entity.Commodity;
import com.cookie.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by koko on 17.08.16.
 */
public interface CommodityRepository extends JpaRepository<Commodity,Integer>{

    @Query("select distinct c from Commodity c left join fetch c.shops")
    List<Commodity> selectFetchShop();

}
