package com.example.computershop.service;

import com.example.computershop.domain.entity.Product;
import com.example.computershop.domain.entity.ProductImage;
import com.example.computershop.mapper.ProductImageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductImageService {
    @Autowired
    private ProductImageMapper productImageMapper;


    public static final String type_single = "single";
    public static final String type_detail = "detail";


    public List<ProductImage> listSingleProductImages(int pid) {
        return productImageMapper.finSingleByPid(pid, type_single);
    }
    public List<ProductImage> listDetailProductImages(int pid) {
        return productImageMapper.finDetailByPid(pid, type_detail);
    }


    public void setFirstProductImage(Product product) {
        List<ProductImage> singleImages = productImageMapper.finSingleByPid(product.getId(),"single");

        if(!singleImages.isEmpty())
            product.setFirstProductImage(singleImages.get(0));
        else
            product.setFirstProductImage(new ProductImage()); //这样做是考虑到产品还没有来得及设置图片，但是在订单后台管理里查看订单项的对应产品图片。
    }
    public void setFirstProductImages(List<Product> products) {
        for (Product product : products)
            setFirstProductImage(product);
    }
}
