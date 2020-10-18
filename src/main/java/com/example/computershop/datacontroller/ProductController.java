package com.example.computershop.datacontroller;

import com.example.computershop.domain.entity.Product;
import com.example.computershop.domain.entity.ProductImage;
import com.example.computershop.domain.vo.PagingResult;
import com.example.computershop.mapper.ProductImageMapper;
import com.example.computershop.mapper.ProductMapper;
import org.apache.logging.log4j.util.ProcessIdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin_product_list/{id}/products")
public class ProductController {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductImageMapper productImageMapper;

    @GetMapping
    public PagingResult<Product> list(@PathVariable("id") int id, @RequestParam(required = false,defaultValue = "0") int offset, @RequestParam(required = false,defaultValue = "10") int size) {
        PagingResult<Product> result = new PagingResult<>();
        List<Product> items = productMapper.list(id,offset,size);
        int count = productMapper.listCount(id);
        result.setTotalCount(count);
        result.setItems(items);
        this.setFirstProductImages(result.getItems());

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
    @GetMapping("/findProduct")
    public Product get(@PathVariable("id") int pid) throws Exception {
        Product bean=productMapper.findByOne(pid);
        return bean;
    }

    public void setFirstProductImage(Product product) {
        List<ProductImage> singleImages = productImageMapper.finSingleByPid(product.getId(),"single");

        if(!singleImages.isEmpty())
            product.setFirstProductImage(singleImages.get(0));
        else
            product.setFirstProductImage(new ProductImage()); //这样做是考虑到产品还没有来得及设置图片，但是在订单后台管理里查看订单项的对应产品图片。
    }
    public void setFirstProductImages(List<Product> products) {
        for (Product product : products)
            setFirstProductImage(product);
    }

}
