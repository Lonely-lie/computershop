package com.example.computershop.mapper;

import com.example.computershop.domain.entity.Product;
import com.example.computershop.domain.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    List<User> listUser(@Param("offset") int offset, @Param("size") int size);
    int listCount();

    User finByOne(int user_id);

    User findByName(String name);//查询是否用户名存在

    int add(User user);//注册用户

    User getByNameAndPassword(String name, String password);


    int updateIcon(int IconImg);//注册用户

}
