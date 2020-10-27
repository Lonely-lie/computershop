package com.example.computershop.comparator;

import com.example.computershop.domain.entity.Product;

import java.util.Comparator;

public class ProductDeclinePriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return (int) (p2.getPro_price()-p1.getPro_price());
    }
}
