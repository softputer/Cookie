package com.cookie.repository;

import com.cookie.entity.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by koko on 17.08.16.
 */
public interface CommodityRepository extends JpaRepository<Commodity,Integer>{
}
