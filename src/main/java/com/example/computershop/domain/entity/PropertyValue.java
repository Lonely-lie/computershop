package com.example.computershop.domain.entity;

import java.time.LocalDateTime;

public class PropertyValue {
    private Integer id;
    private Integer product_id;
    private Integer property_id;
    private Property property;
    private Product product;
    private String value;
    private LocalDateTime updateTime =LocalDateTime.now();
    private LocalDateTime createTime =LocalDateTime.now();
    private boolean isDelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getProperty_id() {
        return property_id;
    }

    public void setProperty_id(Integer property_id) {
        this.property_id = property_id;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public PropertyValue(Integer id, Integer product_id, Integer property_id, Property property, Product product, String value, LocalDateTime updateTime, LocalDateTime createTime, boolean isDelete) {
        this.id = id;
        this.product_id = product_id;
        this.property_id = property_id;
        this.property = property;
        this.product = product;
        this.value = value;
        this.updateTime = updateTime;
        this.createTime = createTime;
        this.isDelete = isDelete;
    }

    public PropertyValue() {
    }
}
