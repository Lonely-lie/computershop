package com.example.computershop.service;

import com.example.computershop.domain.entity.User;
import com.example.computershop.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public boolean isExist(String name) {
        User user = getByName(name);
        return user!=null;
    }

    public User getByName(String name) {
        return userMapper.findByName(name);
    }

    public void add(User user) {
        userMapper.add(user);
    }
    public User get(String name, String password) {
        return userMapper.getByNameAndPassword(name,password);
    }

}
