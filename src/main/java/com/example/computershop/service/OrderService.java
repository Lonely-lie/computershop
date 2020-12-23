package com.example.computershop.service;

import com.example.computershop.domain.entity.Order;
import com.example.computershop.domain.entity.OrderItem;
import com.example.computershop.domain.entity.User;
import com.example.computershop.mapper.OrderItemMapper;
import com.example.computershop.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class OrderService {
    public static final String waitPay = "waitPay";
    public static final String waitDelivery = "waitDelivery";
    public static final String waitConfirm = "waitConfirm";
    public static final String waitReview = "waitReview";
    public static final String finish = "finish";
    public static final String delete = "delete";

    @Autowired
    OrderItemService orderItemService;

    @Autowired
    OrderMapper orderMapper;

    public Order getByOid(int oid) {
        return orderMapper.findByOrderId(oid);
    }

    public void update(Order bean) {
        orderMapper.update(bean);
    }
    public int add(Order order) {
        return orderMapper.add(order);
    }
    @Transactional(propagation= Propagation.REQUIRED,rollbackForClassName="Exception")
    public float add(Order order, List<OrderItem> ois,Object oiid) {
        float total = 0;
        //订单中添加一条数据
        add(order);
//        System.out.println("我的oid是——————"+order.getId());
        if(false)
            throw new RuntimeException("eee");

        //判断是否是立即购买
        if (oiid==null)
            for (OrderItem oi: ois) {
                oi.setPro_id(oi.getProduct().getId());
                //在订单项中创建立即购买的商品
                orderItemService.add(oi);
            }
        for (OrderItem oi: ois) {
            //给订单项设置订单ID
            oi.setOrder_id(order.getId());
            //更新订单项
            orderItemService.update(oi);
            //返回金额
            total+=oi.getProduct().getPro_price()*oi.getNumber();
        }
        return total;
    }

    public List<Order> listByUserWithoutDelete(User user) {
        //获取用户所有未删除的订单
        List<Order> orders = listByUserAndNotDeleted(user.getId());
        orderItemService.fill(orders);
        return orders;
    }
    public List<Order> listByUserAndNotDeleted(int uid) {
        return orderMapper.findByUserAndStatusNotOrderByIdDesc(uid, OrderService.delete);
    }

    public void cacl(Order o) {
        List<OrderItem> orderItems = o.getOrderItems();
        float total = 0;
        for (OrderItem orderItem : orderItems) {
            total+=orderItem.getProduct().getPro_price()*orderItem.getNumber();
        }
        o.setTotal(total);
    }

}
