package com.example.computershop.mapper;

import com.example.computershop.domain.entity.ProductType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
//@Mapper
public interface ProductTypeMapper {
    List<ProductType> list(@Param("offset") int offset, @Param("size") int size);

}
