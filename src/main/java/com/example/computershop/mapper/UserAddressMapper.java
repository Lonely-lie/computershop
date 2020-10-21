package com.example.computershop.mapper;

import com.example.computershop.domain.entity.UserAddress;

public interface UserAddressMapper {

    UserAddress findOneByID(int user_address_id);

}
