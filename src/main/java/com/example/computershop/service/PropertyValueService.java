package com.example.computershop.service;

import com.example.computershop.domain.entity.PropertyValue;
import com.example.computershop.mapper.PropertyMapper;
import com.example.computershop.mapper.PropertyValueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PropertyValueService {
    @Autowired
    PropertyValueMapper propertyValueMapper;
    @Autowired
    private PropertyMapper propertyMapper;


    public List<PropertyValue> list(int  pid) {
         List<PropertyValue> propertyValues = propertyValueMapper.findProductVaLueListByPid(pid);
         return getPropertyValue(propertyValues,pid);


    }
    public List<PropertyValue> getPropertyValue(List<PropertyValue> list,int pid){
        for (PropertyValue propertyValue:list){
            propertyValue.setProperty(propertyMapper.findByPropertyId(propertyValue.getProperty_id()));
        }
        return list;
    }



}
