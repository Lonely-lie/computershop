package com.example.computershop.service;

import com.example.computershop.domain.entity.UserAddress;
import com.example.computershop.mapper.UserAddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAddressService {
    @Autowired
    UserAddressMapper userAddressMapper;
    public List<UserAddress> findByUserID(int uid){//立即购买
        return userAddressMapper.findAllByUid(uid);
    }
}
