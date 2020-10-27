package com.example.computershop.comparator;

import com.example.computershop.domain.entity.Product;

import java.util.Comparator;

public class ProductReviewComparator implements Comparator<Product> {

    /**
     * 根据商品评价数量
     * @param p1
     * @param p2
     * @return
     */
    @Override
    public int compare(Product p1, Product p2) {
        return p2.getReviewCount()-p1.getReviewCount();
    }
}
