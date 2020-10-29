package com.example.computershop.mapper;

import com.example.computershop.domain.entity.Product;
import com.example.computershop.domain.entity.Property;
import org.apache.ibatis.annotations.Param;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;

import java.util.List;

public interface ProductMapper {
    List<Product> list(@Param("id") int id, @Param("offset") int offset, @Param("size") int size);

    int listCount(@Param("id") int id);

    int update(Product product);

    int insert(Product product);

    int deleteUpdate(Product product);

    Product findByOne(int pid);


    List<Product> findListProductByPro_type_id(int pro_type_id);

    List<Product> findByNameLike(String keyword);//模糊搜索
}
