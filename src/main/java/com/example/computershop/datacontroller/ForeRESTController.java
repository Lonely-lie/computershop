package com.example.computershop.datacontroller;

import com.example.computershop.domain.entity.ProductType;
import com.example.computershop.mapper.ProductTypeMapper;
import com.example.computershop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ForeRESTController {

    @Autowired
    ProductTypeMapper productTypeMapper;
    @Autowired
    ProductService productService;

    @GetMapping("/foreHome")
    public Object home() {
        List<ProductType> productTypes= productTypeMapper.listAll(); //获取所有商品类型集合
        productService.fill(productTypes);  //把获取的商品类型集合通过fill填充函数，对商品类型填充商品集合，商品集合里面每个商品填充first缩略图
        productService.fillByRow(productTypes);
//        categoryService.removeCategoryFromProduct(productTypes);
        return productTypes;
    }
}
