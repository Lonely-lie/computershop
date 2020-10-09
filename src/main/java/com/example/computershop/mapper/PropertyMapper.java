package com.example.computershop.mapper;

import com.example.computershop.domain.entity.ProductType;
import com.example.computershop.domain.entity.Property;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PropertyMapper {
    List<Property> list(@Param("id") int id,@Param("offset") int offset, @Param("size") int size);
    int listCount(@Param("id") int id);

    int update(Property property);

    int insert(Property property);

    int deleteUpdate(Property property);

}
