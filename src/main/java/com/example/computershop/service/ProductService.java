package com.example.computershop.service;

import com.example.computershop.domain.entity.Product;
import com.example.computershop.domain.entity.ProductType;
import com.example.computershop.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductService {

    @Autowired
    ProductImageService productImageService;
    @Autowired
    ProductMapper productMapper;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    ReviewService reviewService;


    public Product get(int pid) {
        return productMapper.findByOne(pid);
    }

    public void fill(List<ProductType> productTypes) {
        for (ProductType productType : productTypes) {
            fill(productType);
        }
    }
    public void fill(ProductType productType) {
        List<Product> products = productMapper.findListProductByPro_type_id(productType.getId()); //通过商品类型ID找到该类型所有商品
        productImageService.setFirstProductImages(products);//对商品进行图片设置
        productType.setProducts(products);
    }

    public void fillByRow(List<ProductType> productTypes) {
        int productNumberEachRow = 5;//分类条目下推荐商品的每行个数
        for (ProductType productType : productTypes) {//遍历商品类型集合
            List<Product> products =  productType.getProducts();//根据单独商品类型获取商品类型下的商品集合
            List<List<Product>> productsByRow =  new ArrayList<>();
            for (int i = 0; i < products.size(); i+=productNumberEachRow) {
                int size = i+productNumberEachRow;
                size= size>products.size()?products.size():size;
                List<Product> productsOfEachRow =products.subList(i, size);
                productsByRow.add(productsOfEachRow);
            }
            productType.setProductsByRow(productsByRow);
        }
    }


    public void setSaleAndReviewNumber(Product product) {
        int saleCount = orderItemService.getSaleCount(product.getId());//根据商品ID获取商品订单并且计算销售数量
        product.setSaleCount(saleCount);//设置销售数量

        int reviewCount = reviewService.getCount(product);//把对象传入 获取评价数量
        product.setReviewCount(reviewCount);//设置评价数量

    }


    public void setSaleAndReviewNumber(List<Product> products) {
        for (Product product : products)
            setSaleAndReviewNumber(product);
    }


}
