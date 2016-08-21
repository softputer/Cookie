package com.cookie.service;

import com.cookie.entity.Commodity;
import com.cookie.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.List;

/**
 * Created by koko on 17.08.16.
 */
public interface UserService {

    void save(User user);
    List<User> findAll();
    User findOne(int id);
    void delete(int id);
    List<User>selectFetchUser();
    public void usersetImage(MultipartFile multipartFile, Principal principal);

}
