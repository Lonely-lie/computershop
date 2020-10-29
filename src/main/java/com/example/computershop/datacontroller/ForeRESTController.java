package com.example.computershop.datacontroller;

import com.example.computershop.comparator.*;
import com.example.computershop.domain.entity.*;
import com.example.computershop.mapper.ProductTypeMapper;
import com.example.computershop.mapper.PropertyValueMapper;
import com.example.computershop.service.*;
import com.example.computershop.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ForeRESTController {

    @Autowired
    ProductTypeMapper productTypeMapper;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    ProductImageService productImageService;
    @Autowired
    PropertyValueService propertyValueService;
    @Autowired
    ReviewService reviewService;
    @Autowired
    ProductTypeService productTypeService;
    @GetMapping("/foreHome")
    public Object home() {//首页商品类型和商品
        List<ProductType> productTypes= productTypeMapper.listAll(); //获取所有商品类型集合
        productService.fill(productTypes);  //把获取的商品类型集合通过fill填充函数，对商品类型填充商品集合，商品集合里面每个商品填充first缩略图
        //进行排序，把最新的放前面
        for (ProductType productType:productTypes )
            Collections.sort(productType.getProducts(),new ProductDateComparator());
        productService.fillByRow(productTypes);
        return productTypes;
    }

    @PostMapping("/foreRegister")//注册
    public Object register(@RequestBody User user) {
        String name =  user.getName();
        String password = user.getPassword();
        name = HtmlUtils.htmlEscape(name);//把账号里的特殊符号进行转义
        user.setName(name);
        boolean exist = userService.isExist(name);//查看用户名是否已经存在

        if(exist){//已经存在
            String message ="用户名已经被使用,不能使用";
            return Result.fail(message);
        }
        user.setDelete(false);
        user.setPassword(password);

        userService.add(user);//往数据库添加一条用户注册数据

        return Result.success();//返回成功信息
    }

    @PostMapping("/foreLogin")//登录
    public Object login(@RequestBody User userParam, HttpSession session) {
        String name =  userParam.getName();//获取登录用户名
        name = HtmlUtils.htmlEscape(name);//转义，防止用户乱输入

        User user =userService.get(name,userParam.getPassword());//数据库中查询是否存在此用户，检验用户名和密码是否都正确
        //如果搜索不到，则错误
        if(user==null){
            String message ="账号密码错误";
            return Result.fail(message);
        }
        else{
            session.setAttribute("user", user);
            return Result.success();
        }
    }

    @GetMapping("/foreProduct/{pid}")//商品页面
    public Object product(@PathVariable("pid") int pid) {
        Product product = productService.get(pid);//获取pid获取商品对象
        List<ProductImage> productSingleImages = productImageService.listSingleProductImages(pid);//根据商品获取商品单个图片
        List<ProductImage> productDetailImages = productImageService.listDetailProductImages(pid);//根据商品获取商品详情图片
        product.setProductSingleImages(productSingleImages);//给商品设置单个图片
        product.setProductDetailImages(productDetailImages);//给商品设置详情图片

        List<PropertyValue> pvs = propertyValueService.list(pid);//根据商品ID获取商品属性值

        List<Review> reviews = reviewService.list(pid);//根据商品ID获取商品评价集合

        productService.setSaleAndReviewNumber(product);

        productImageService.setFirstProductImage(product);



        Map<String,Object> map= new HashMap<>();
        map.put("product", product);
        map.put("pvs", pvs);
        map.put("reviews", reviews);

        return Result.success(map);
    }

    @GetMapping("foreCheckLogin")//验证是否登录
    public Object checkLogin( HttpSession session) {
        User user =(User)  session.getAttribute("user");
        if(user!=null)
            return Result.success();
        return Result.fail("未登录");
    }


    @GetMapping("foreCategory/{cid}")//商品类型页面
    public Object category(@PathVariable int cid,@RequestParam(required = false,defaultValue = "") String sort) {
        ProductType productType = productTypeService.get(cid);
        System.out.println(productType);
        productService.fill(productType);
        productService.setSaleAndReviewNumber(productType.getProducts());
//        productTypeService.removeCategoryFromProduct(c);

        if(null!=sort){
            switch(sort){
                case "all"://综合 商品评价数量*商品销售数量
                    Collections.sort(productType.getProducts(),new ProductAllComparator());
                    break;
                case "review"://人气  根据商品评价数量
                    Collections.sort(productType.getProducts(),new ProductReviewComparator());
                    break;
                case "date" ://创建时间  新品
                    Collections.sort(productType.getProducts(),new ProductDateComparator());
                    break;

                case "saleCount" ://销售数量
                    Collections.sort(productType.getProducts(),new ProductSaleCountComparator());
                    break;
                case "price"://价格
                    Collections.sort(productType.getProducts(),new ProductPriceComparator());
                    break;
                case "declinePrice"://价格
                    Collections.sort(productType.getProducts(),new ProductDeclinePriceComparator());
                    break;
            }
        }
        return productType;
    }

    @PostMapping("foreSearch")//搜索
    public Object search(String keyword){
        if(keyword==null)
            keyword = "";
        List<Product> ps= productService.search(keyword,0,20);
        productImageService.setFirstProductImages(ps);
        productService.setSaleAndReviewNumber(ps);
        return ps;
    }
}