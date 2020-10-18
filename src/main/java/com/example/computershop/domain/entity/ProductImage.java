package com.example.computershop.domain.entity;

public class ProductImage {
    private Integer id; //产品图片ID
    private Integer product_id; //产品ID
    private String type;    //

    public ProductImage() {
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ProductImage(Integer id, Integer product_id, String type) {
        this.id = id;
        this.product_id = product_id;
        this.type = type;
    }
}
