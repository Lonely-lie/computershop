package com.example.computershop.domain.entity;

import java.time.LocalDateTime;

public class Product {
    private Integer id; //商品ID
    private String name;    //商品名
    private String pro_img; //商品图片
    private String pro_desc; //商品描述
    private double pro_price; //商品价格
    private Integer rest_stock; //商品库存
    private Integer shop_id;    //商家ID，参照shop_info表
    private Integer pro_type_id;    //商品类型ID，参照pro_type_info表
    private LocalDateTime updateTime =LocalDateTime.now();
    private LocalDateTime createTime =LocalDateTime.now();
    private boolean isDelete;
    private ProductImage firstProductImage;

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPro_img() {
        return pro_img;
    }

    public void setPro_img(String pro_img) {
        this.pro_img = pro_img;
    }

    public String getPro_desc() {
        return pro_desc;
    }

    public void setPro_desc(String pro_desc) {
        this.pro_desc = pro_desc;
    }

    public double getPro_price() {
        return pro_price;
    }

    public void setPro_price(double pro_price) {
        this.pro_price = pro_price;
    }

    public Integer getRest_stock() {
        return rest_stock;
    }

    public void setRest_stock(Integer rest_stock) {
        this.rest_stock = rest_stock;
    }

    public Integer getShop_id() {
        return shop_id;
    }

    public void setShop_id(Integer shop_id) {
        this.shop_id = shop_id;
    }

    public Integer getPro_type_id() {
        return pro_type_id;
    }

    public void setPro_type_id(Integer pro_type_id) {
        this.pro_type_id = pro_type_id;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public ProductImage getFirstProductImage() {
        return firstProductImage;
    }

    public void setFirstProductImage(ProductImage firstProductImage) {
        this.firstProductImage = firstProductImage;
    }

    public Product(Integer id, String name, String pro_img, String pro_desc, double pro_price, Integer rest_stock, Integer shop_id, Integer pro_type_id, LocalDateTime updateTime, LocalDateTime createTime, boolean isDelete, ProductImage firstProductImage) {
        this.id = id;
        this.name = name;
        this.pro_img = pro_img;
        this.pro_desc = pro_desc;
        this.pro_price = pro_price;
        this.rest_stock = rest_stock;
        this.shop_id = shop_id;
        this.pro_type_id = pro_type_id;
        this.updateTime = updateTime;
        this.createTime = createTime;
        this.isDelete = isDelete;
        this.firstProductImage = firstProductImage;
    }
}

