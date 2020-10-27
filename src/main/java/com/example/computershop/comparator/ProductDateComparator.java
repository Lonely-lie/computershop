package com.example.computershop.comparator;

import com.example.computershop.domain.entity.Product;

import java.util.Comparator;

public class ProductDateComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return p2.getCreateTime().compareTo(p1.getCreateTime());
    }
}
