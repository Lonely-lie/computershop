package com.example.computershop.datacontroller;

import com.example.computershop.domain.entity.*;
import com.example.computershop.domain.vo.PagingResult;
import com.example.computershop.mapper.*;
import com.example.computershop.service.OrderItemService;
import com.example.computershop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@RestController

public class OrderController {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductImageMapper productImageMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserAddressMapper userAddressMapper;
    @Autowired
    OrderItemService orderItemService;

    @GetMapping("/orders")
    public PagingResult<Order> list(@RequestParam(required = false,defaultValue = "0") int offset, @RequestParam(required = false,defaultValue = "10") int size) {
        PagingResult<Order> result = new PagingResult<>();
        List<Order> items = orderMapper.list(offset,size); //获取所有订单集合
        int count = orderMapper.listCount();//获取总共订单数量
        result.setTotalCount(count);
        result.setItems(items);
        orderItemService.fill(result.getItems());//重新配置，set其他属性
        return result;
    }
    @PutMapping("deliveryOrder/{oid}")
    public Object deliveryOrder(@PathVariable int oid) throws IOException {
        Order order = orderMapper.findByOrderId(oid);
        order.setDeliveryDate(LocalDateTime.now()); //设置发货时间
        order.setStatus(OrderService.waitConfirm);  //设置订单状态
        orderMapper.update(order);
        return order;
    }


}
