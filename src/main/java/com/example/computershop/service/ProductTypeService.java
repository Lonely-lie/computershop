package com.example.computershop.service;

import com.example.computershop.domain.entity.ProductType;
import com.example.computershop.mapper.ProductTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeService {
    @Autowired
    ProductTypeMapper productTypeMapper;
    public ProductType get(int tid) {
        ProductType productType= productTypeMapper.findByOne(tid);
        return productType;
    }

}
