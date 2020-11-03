package com.example.computershop.service;

import com.example.computershop.domain.entity.Order;
import com.example.computershop.domain.entity.OrderItem;
import com.example.computershop.domain.entity.Product;
import com.example.computershop.mapper.OrderItemMapper;
import com.example.computershop.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderItemService {
    @Autowired
    OrderItemMapper orderItemMapper;
    @Autowired
    OrderMapper orderMapper;


    public int getSaleCount(int pid) {
        List<OrderItem> orderItems =listByProduct(pid);
        int result =0;
        for (OrderItem orderItem : orderItems) {
            Order order =orderMapper.findByOrderId(orderItem.getId());//根据订单项Order_id获取订单对象
            if (order!=null)
                if (order.getPayDate()!=null)
                    result+=orderItem.getNumber();

        }
        return result;
    }

    public List<OrderItem> listByProduct(int pid) {
        return orderItemMapper.findByPid(pid);
    }

    //获取没有订单的订单项，即购物车
    public List<OrderItem> listCartByUser(int uid){
        return orderItemMapper.findCartByUid(uid);
    }


    public void update(OrderItem orderItem) {
        orderItemMapper.update(orderItem);
    }

    //购物车改变商品数量
    public void foreChangeCart(int pro_id,int user_id,int number) {
        orderItemMapper.foreChangeCartNumber(pro_id,user_id,number);
    }

    public int deleteOrderItem(int oiid) {
        return orderItemMapper.deleteOrderItem(oiid);
    }

    public void add(OrderItem orderItem) {
        orderItemMapper.add(orderItem);
    }

    public OrderItem get(int id) {
        return orderItemMapper.findByOrderItemId(id);
    }
}
