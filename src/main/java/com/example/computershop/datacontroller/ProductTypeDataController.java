package com.example.computershop.datacontroller;

import com.example.computershop.domain.entity.ProductType;
import com.example.computershop.domain.vo.PagingResult;
import com.example.computershop.mapper.ProductTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/productType")
public class ProductTypeDataController {
    @Autowired
    private ProductTypeMapper productTypeMapper;
    @GetMapping
    public PagingResult<ProductType> list(@RequestParam(required = false,defaultValue = "0") int offset, @RequestParam(required = false,defaultValue = "10") int size) {
        PagingResult<ProductType> result = new PagingResult<>();
        List<ProductType> items = productTypeMapper.list(offset,size);
        int count = productTypeMapper.listCount();
        result.setTotalCount(count);
        result.setItems(items);
        return result;
    }

    @PostMapping()//新增商品类型
    @ResponseStatus(code = HttpStatus.CREATED)
    public ProductType insert(@RequestBody ProductType productType) {
        productTypeMapper.insert(productType);
        return productType;
    }
    @PutMapping()//编辑更新商品类型
    @ResponseStatus(code = HttpStatus.CREATED)
    public ProductType save(@RequestBody ProductType productType) {
        productTypeMapper.update(productType);
        return productType;
    }

    @PutMapping("delete")//删除商品类型，更改is_delete
    @ResponseStatus(code = HttpStatus.CREATED)
    public ProductType deleteUpdate(@RequestBody ProductType productType) {
        productTypeMapper.deleteUpdate(productType);
        return productType;
    }


}

