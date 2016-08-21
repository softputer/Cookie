package com.cookie.repository;

import com.cookie.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by koko on 19.08.16.
 */
public interface ShopRepository extends JpaRepository<Shop, Integer>{

}
