package com.example.computershop.mapper;

import com.example.computershop.domain.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    List<User> listUser(@Param("offset") int offset, @Param("size") int size);
    int listCount();

}
