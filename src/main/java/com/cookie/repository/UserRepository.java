package com.cookie.repository;

import com.cookie.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by koko on 17.08.16.
 */
public interface UserRepository extends JpaRepository<User,Integer>{

    @Query("select u from User u where u.username=:name")
    User findOneByName(@Param(value = "name") String name);

}
