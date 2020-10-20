package com.example.computershop.mapper;

import com.example.computershop.domain.entity.Order;
import com.example.computershop.domain.entity.Product;
import com.example.computershop.domain.entity.ProductType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {



    List<Order> list(@Param("offset") int offset, @Param("size") int size);
    int listCount();

    Order findByOrderId(@Param("oid")int oid);


    int update(Order order);



}
