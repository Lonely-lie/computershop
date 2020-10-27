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

}
