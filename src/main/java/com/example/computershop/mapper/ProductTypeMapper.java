package com.example.computershop.mapper;

import com.example.computershop.domain.entity.ProductType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
//@Mapper
public interface ProductTypeMapper {
    //获取分类数据，list
    List<ProductType> list(@Param("offset") int offset, @Param("size") int size);
    //获取分类数据总数量
    int listCount();

    int insert(ProductType productType);

    int update(ProductType productType);

    int deleteUpdate(ProductType productType);



}
