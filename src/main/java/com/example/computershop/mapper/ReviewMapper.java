package com.example.computershop.mapper;

import com.example.computershop.domain.entity.Product;
import com.example.computershop.domain.entity.ProductImage;
import com.example.computershop.domain.entity.Review;

import java.util.List;

public interface ReviewMapper {
    List<Review> findReviewListByPid(int pid);   //根据商品ID搜索所有评价

    int findCountByPid(int pid);//根据商品ID获取商品的评价数量

    int add(Review review);//新增评价

}
