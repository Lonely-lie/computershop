package com.example.computershop.domain.entity;

import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;
import java.util.List;

public class ProductType {


    List<Product> products; //代表一个分类下有多个产品。
    List<List<Product>> productsByRow;//一个分类会对应多行产品，而一行产品里又有多个产品记录






    private Integer id;
    private String name;
    private LocalDateTime updateTime =LocalDateTime.now();
    private LocalDateTime createTime =LocalDateTime.now();
    private boolean isDelete;

    public ProductType() {
    }

    public ProductType(Integer id, String name, LocalDateTime updateTime, LocalDateTime createTime, boolean isDelete) {
        this.id = id;
        this.name = name;
        this.updateTime = updateTime;
        this.createTime = createTime;
        this.isDelete = isDelete;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<List<Product>> getProductsByRow() {
        return productsByRow;
    }

    public void setProductsByRow(List<List<Product>> productsByRow) {
        this.productsByRow = productsByRow;
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

    @Override
    public String toString() {
        return "ProductType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", updateTime=" + updateTime +
                ", createTime=" + createTime +
                ", isDelete=" + isDelete +
                '}';
    }
}
