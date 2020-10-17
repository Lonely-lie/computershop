package com.example.computershop.datacontroller;

import com.example.computershop.domain.entity.ProductType;
import com.example.computershop.domain.entity.Property;
import com.example.computershop.domain.vo.PagingResult;
import com.example.computershop.mapper.PropertyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin_property_list/{id}/properties")
public class PropertyController {
    @Autowired
    private PropertyMapper propertyMapper;
    @GetMapping
    public PagingResult<Property> list(@PathVariable("id") int id, @RequestParam(required = false,defaultValue = "0") int offset, @RequestParam(required = false,defaultValue = "10") int size) {
        PagingResult<Property> result = new PagingResult<>();
        List<Property> items = propertyMapper.list(id,offset,size);
        int count = propertyMapper.listCount(id);
        result.setTotalCount(count);
        result.setItems(items);
        return result;
    }
    @PutMapping//编辑更新商品类型
    @ResponseStatus(code = HttpStatus.CREATED)
    public Property save(@RequestBody Property property) {
        propertyMapper.update(property);
        return property;
    }

    @PostMapping //新增商品类型
    @ResponseStatus(code = HttpStatus.CREATED)
    public Property insert(@RequestBody Property Property) {
        propertyMapper.insert(Property);
        return Property;
    }

    @PutMapping("delete")//删除商品类型，更改is_delete
    @ResponseStatus(code = HttpStatus.CREATED)
    public Property deleteUpdate(@RequestBody Property property) {
        propertyMapper.deleteUpdate(property);
        return property;
    }
}
