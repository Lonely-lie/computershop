package com.example.computershop.mapper;

import com.example.computershop.domain.entity.Order;
import com.example.computershop.domain.entity.OrderItem;
import com.example.computershop.domain.entity.ProductType;

import java.util.List;

public interface OrderItemMapper {

    List<OrderItem> findByOrderOrderByIdDesc(int order_id);
    List<OrderItem> findByPid(int pid);
    List<OrderItem> findByUid(int uid);

    int update(OrderItem orderItem);
    int add(OrderItem orderItem);



}
