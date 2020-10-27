package com.example.computershop.mapper;

import com.example.computershop.domain.entity.Property;
import com.example.computershop.domain.entity.PropertyValue;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PropertyValueMapper {

    void initSave(PropertyValue propertyValue);//初始化商品属性值

    List<PropertyValue> findProductVaLueListByPid(@Param("pid")  int pid); //根据商品ID搜索商品属性值

    PropertyValue getByPropertyIDAndProductID(int pid, int property_id); //根据商品ID和属性ID查询商品属性值对象

    void update(PropertyValue propertyValue);




}
