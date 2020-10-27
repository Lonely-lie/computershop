package com.example.computershop.comparator;

import com.example.computershop.domain.entity.Product;

import java.util.Comparator;

public class ProductAllComparator implements Comparator<Product> {

    /**
     * 综合排序，根据
     *      商品评价数量*商品销售数量
     * @param p1
     * @param p2
     * @return
     */
    @Override
    public int compare(Product p1, Product p2) {
        return p2.getReviewCount()*p2.getSaleCount()-p1.getReviewCount()*p1.getSaleCount();
    }

}
