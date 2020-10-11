package com.example.computershop.datacontroller;

import com.example.computershop.domain.entity.Product;
import com.example.computershop.domain.vo.PagingResult;
import com.example.computershop.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin_product_list/{id}/products")
public class ProductController {
    @Autowired
    private ProductMapper productMapper;
    @GetMapping
    public PagingResult<Product> list(@PathVariable("id") int id, @RequestParam(required = false,defaultValue = "0") int offset, @RequestParam(required = false,defaultValue = "10") int size) {
        PagingResult<Product> result = new PagingResult<>();
        List<Product> items = productMapper.list(id,offset,size);
        int count = productMapper.listCount(id);
        result.setTotalCount(count);
        result.setItems(items);
        return result;
    }
    @PutMapping//编辑更新商品类型
    @ResponseStatus(code = HttpStatus.CREATED)
    public Product save(@RequestBody Product product) {
        productMapper.update(product);
        return product;
    }

    @PostMapping //新增商品类型
    @ResponseStatus(code = HttpStatus.CREATED)
    public Product insert(@RequestBody Product product) {
        productMapper.insert(product);
        return product;
    }

    @PutMapping("delete")//删除商品类型，更改is_delete
    @ResponseStatus(code = HttpStatus.CREATED)
    public Product deleteUpdate(@RequestBody Product product) {
        productMapper.deleteUpdate(product);
        return product;
    }
}
