package com.example.computershop.datacontroller;

import com.example.computershop.domain.entity.*;
import com.example.computershop.domain.vo.PagingResult;
import com.example.computershop.mapper.*;
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
    @GetMapping("/orders")
    public PagingResult<Order> list(@RequestParam(required = false,defaultValue = "0") int offset, @RequestParam(required = false,defaultValue = "10") int size) {
        PagingResult<Order> result = new PagingResult<>();
        List<Order> items = orderMapper.list(offset,size); //获取所有订单集合
        int count = orderMapper.listCount();//获取总共订单数量
        result.setTotalCount(count);
        result.setItems(items);
        this.fill(result.getItems());//重新配置，set其他属性
        return result;
    }
    @PutMapping("deliveryOrder/{oid}")
    public Object deliveryOrder(@PathVariable int oid) throws IOException {
        Order order = orderMapper.findByOrderId(oid);
        order.setDeliveryDate(LocalDateTime.now());
        order.setStatus(OrderService.waitConfirm);
        orderMapper.update(order);
        return order;
    }

















    public void fill(List<Order> orders) {
        for (Order order : orders)
            fill(order);
    }
    public void fill(Order order) {
        order.checkStatus();
        List<OrderItem> orderItems = orderItemMapper.findByOrderOrderByIdDesc(order.getId());
        order.setUser(userMapper.finByOne(order.getUser_id()));
        float total = 0;
        int totalNumber = 0;
        for (OrderItem oi :orderItems) {
            Product product =productMapper.findByOne(oi.getPro_id());
            oi.setProduct(product);
//            total+=oi.getNumber()*oi.getProduct().getPromotePrice();
            total+=oi.getNumber()*product.getPro_price();//总金钱=购买数量*购买商品价格
            totalNumber+=oi.getNumber(); //总数量
            this.setFirstProductImage(product);
        }
        order.setTotal(total);
        order.setTotalNumber(totalNumber);
        order.setOrderItems(orderItems);
    }
    public void setFirstProductImage(Product product) {
        List<ProductImage> singleImages = productImageMapper.finSingleByPid(product.getId(),"single");

        if(!singleImages.isEmpty())
            product.setFirstProductImage(singleImages.get(0));
        else
            product.setFirstProductImage(new ProductImage()); //这样做是考虑到产品还没有来得及设置图片，但是在订单后台管理里查看订单项的对应产品图片。
    }
    public void setFirstProductImages(List<Product> products) {
        for (Product product : products)
            setFirstProductImage(product);
    }









}
