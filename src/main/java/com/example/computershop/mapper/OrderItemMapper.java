package com.example.computershop.mapper;

import com.example.computershop.domain.entity.Order;
import com.example.computershop.domain.entity.OrderItem;

import java.util.List;

public interface OrderItemMapper {

    List<OrderItem> findByOrderOrderByIdDesc(int order_id);

}
