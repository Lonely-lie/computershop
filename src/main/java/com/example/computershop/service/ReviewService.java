package com.example.computershop.service;

import com.example.computershop.domain.entity.Product;
import com.example.computershop.domain.entity.Review;
import com.example.computershop.mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    ReviewMapper reviewMapper;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    public void add(Review review) {
        reviewMapper.add(review);
    }

    public List<Review> list(int pid){
        List<Review> result =  reviewMapper.findReviewListByPid(pid);
        for (Review review:result)//遍历，对每个review评价设置用户对象
            review.setUser(userService.getByUserId(review.getUser_id()));
        return result;
    }

    //根据商品ID，获取商品评价数量
    public int getCount(Product product) {
        return reviewMapper.findCountByPid(product.getId());
    }
}
