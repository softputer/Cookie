package com.cookie.service;

import com.cookie.entity.Commodity;
import com.cookie.entity.User;

import java.util.List;

/**
 * Created by koko on 17.08.16.
 */
public interface UserService {

    void save(User user);
    List<User> findAll();
    User findOne(int id);
    void delete(int id);

}
