package com.example.computershop.datacontroller;

import com.example.computershop.domain.entity.Product;
import com.example.computershop.domain.entity.Property;
import com.example.computershop.domain.entity.PropertyValue;
import com.example.computershop.mapper.ProductMapper;
import com.example.computershop.mapper.PropertyMapper;
import com.example.computershop.mapper.PropertyValueMapper;
import com.example.computershop.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/products/{pid}/propertyValues")
public class PropertyValueController {

    @Autowired
    private PropertyValueMapper propertyValueMapper;
    @Autowired
    private PropertyMapper propertyMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private PropertyValueService propertyValueService;
    @GetMapping
    public List<PropertyValue> list(@PathVariable("pid") int pid) {
        Product product = productMapper.findByOne(pid);//
        this.init(product);//对产品进行初始化，设置属性值
        List<PropertyValue> propertyValues = propertyValueMapper.findProductVaLueListByPid(pid);
        propertyValueService.getPropertyValue(propertyValues,pid);
        return propertyValues;
    }
    @PutMapping("/update")
    public PropertyValue update(@RequestBody PropertyValue propertyValue ) throws Exception {
        propertyValueMapper.update(propertyValue);
        return null;
    }

    public void init(Product product) {
        List<Property> properties= propertyMapper.findByTypeId(product.getPro_type_id());//获取商品类型的所有属性
        for (Property property: properties) {
            PropertyValue propertyValue = propertyValueMapper.getByPropertyIDAndProductID(product.getId(),property.getId());
            if(propertyValue==null){
                propertyValue = new PropertyValue();
                propertyValue.setProduct_id(product.getId());
                propertyValue.setProperty_id(property.getId());
                propertyValue.setProduct(product);
                propertyValue.setProperty(property);
                propertyValue.setCreateTime(LocalDateTime.now());
                propertyValue.setUpdateTime(LocalDateTime.now());
                propertyValue.setDelete(false);
                propertyValueMapper.initSave(propertyValue);
            }
        }
    }




}
