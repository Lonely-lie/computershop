package com.example.computershop.datacontroller;

import com.example.computershop.domain.entity.ProductType;
import com.example.computershop.mapper.ProductTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/productType")
public class ProductTypeDataController {
    @Autowired
    private ProductTypeMapper productTypeMapper;
    @GetMapping
    public List<ProductType> list(@RequestParam(required = false,defaultValue = "0") int offset, @RequestParam(required = false,defaultValue = "10") int size) {
        List<ProductType> items = productTypeMapper.list(offset,size);
        return items;
    }
}

