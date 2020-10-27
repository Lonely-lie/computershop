package com.example.computershop.mapper;

import com.example.computershop.domain.entity.Product;
import com.example.computershop.domain.entity.ProductImage;
import com.example.computershop.domain.entity.Property;

import java.util.List;

public interface ProductImageMapper {
    public static final String type_single = "single";
    public static final String type_detail = "detail";

    public List<ProductImage> finSingleByPid(int pid,String type_single);
    public List<ProductImage> finDetailByPid(int pid,String type_detail);



    int add(ProductImage productImage);

    ProductImage findOne(int id);

    int delete(int id);





}
