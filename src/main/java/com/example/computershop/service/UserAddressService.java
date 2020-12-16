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


    //通过地址ID查找地址对象
    public UserAddress findByUserAddressId(int adId){
        return userAddressMapper.findOneByID(adId);
    }



    public int insert(UserAddress userAddress){
        return userAddressMapper.insert(userAddress);
    }



    public int delete(int id){
        return  userAddressMapper.delete(id);
    }
}
