package com.cookie.serviceImpl;

import com.cookie.entity.User;
import com.cookie.repository.UserRepository;
import com.cookie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.NoResultException;
import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by koko on 17.08.16.
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));

        userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findOne(int id) {
        return userRepository.findOne(id);
    }

    @Override
    public void delete(int id) {
        userRepository.delete(id);
    }

    @Override
    public List<User> selectFetchUser() {
        return userRepository.selectFetchUser();
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user;
        try {
            user = userRepository.findOneByName(name);// userinfo from database
        }catch (NoResultException e){
            return null;
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new org.springframework.security.core.userdetails.User(String.valueOf(user.getId()), user.getPassword(), authorities );

    }

    @Transactional
    public void usersetImage(MultipartFile multipartFile, Principal principal){


        User user = userRepository.findOne(Integer.parseInt(principal.getName()));

        File fileForDelete = new File("/home/koko/eclipseSpace/Cookie/src/main/web/resources/"+user.getUsername()+"/avatar.jpg");
        fileForDelete.delete();
        String avatar = "avatar.jpg";

        user.setAvatar("/home/koko/eclipseSpace/Cookie/src/main/web/resources/"+user.getUsername()+"/"+avatar);

        File file = new File("/home/koko/eclipseSpace/Cookie/src/main/web/resources/"+user.getUsername()+"/"+avatar);
        file.mkdirs();
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
