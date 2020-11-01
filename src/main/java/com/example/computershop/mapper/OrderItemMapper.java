package com.example.computershop.mapper;

import com.example.computershop.domain.entity.OrderItem;

import java.util.List;

public interface OrderItemMapper {

    List<OrderItem> findByOrderOrderByIdDesc(int order_id);
    List<OrderItem> findByPid(int pid);
    List<OrderItem> findCartByUid(int uid);//获取没有订单的订单项，即购物车

    int update(OrderItem orderItem);

    int foreChangeCartNumber(int pro_id,int user_id ,int number);

    int add(OrderItem orderItem);

    int deleteOrderItem(int oiid);

}
