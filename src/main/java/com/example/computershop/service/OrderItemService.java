package com.example.computershop.service;

import com.example.computershop.domain.entity.Order;
import com.example.computershop.domain.entity.OrderItem;
import com.example.computershop.domain.entity.Product;
import com.example.computershop.domain.entity.ProductImage;
import com.example.computershop.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderItemService {
    @Autowired
    OrderItemMapper orderItemMapper;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserAddressMapper userAddressMapper;
    @Autowired
    ProductMapper productMapper;
    @Autowired
    ProductImageMapper productImageMapper;
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


    public void fill(List<Order> orders) {
        for (Order order : orders)
            fill(order);
    }
    public void fill(Order order) {
        //设置订单中文状态
        order.checkStatus();
        //获取订单下的订单项
        List<OrderItem> orderItems = orderItemMapper.findByOrderOrderByIdDesc(order.getId());
        //为订单设置用户
        order.setUser(userMapper.finByOne(order.getUser_id()));
        //为订单设置用户地址
        order.setUserAddress(userAddressMapper.findOneByID(order.getUser_address_id()));
        float total = 0;
        int totalNumber = 0;
        //遍历订单项，设置产品和产品图片
        for (OrderItem oi :orderItems) {
            Product product =productMapper.findByOne(oi.getPro_id());
            oi.setProduct(product);
//            total+=oi.getNumber()*oi.getProduct().getPromotePrice();
            total+=oi.getNumber()*product.getPro_price();//总金钱=购买数量*购买商品价格
            totalNumber+=oi.getNumber(); //总数量
            this.setFirstProductImage(product);
        }
        //设置数量
        order.setTotal(total);
        //设置总金额
        order.setTotalNumber(totalNumber);
        //设置订单项s
        order.setOrderItems(orderItems);
    }
    //商品缩略图设置
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
