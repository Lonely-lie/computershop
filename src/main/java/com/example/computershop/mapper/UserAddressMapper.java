package com.example.computershop.mapper;

import com.example.computershop.domain.entity.UserAddress;

import java.util.List;

public interface UserAddressMapper {

    UserAddress findOneByID(int user_address_id);


    List<UserAddress> findAllByUid(int uid);//立即购买
}
