package com.example.computershop.domain.entity;

public class OrderItem {
    private Integer id;   //订单项ID
    private Integer pro_id; //商品ID
    private Integer order_id;//订单ID
    private Integer user_id;//用户ID
    private Integer number;//购买数量
    private Product product;
    public OrderItem() {
    }

    public OrderItem(Integer id, Integer pro_id, Integer order_id, Integer user_id, Integer number, Product product) {
        this.id = id;
        this.pro_id = pro_id;
        this.order_id = order_id;
        this.user_id = user_id;
        this.number = number;
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPro_id() {
        return pro_id;
    }

    public void setPro_id(Integer pro_id) {
        this.pro_id = pro_id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
