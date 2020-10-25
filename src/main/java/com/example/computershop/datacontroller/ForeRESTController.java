package com.example.computershop.datacontroller;

import com.example.computershop.domain.entity.ProductType;
import com.example.computershop.domain.entity.User;
import com.example.computershop.mapper.ProductTypeMapper;
import com.example.computershop.service.ProductService;
import com.example.computershop.service.UserService;
import com.example.computershop.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class ForeRESTController {

    @Autowired
    ProductTypeMapper productTypeMapper;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @GetMapping("/foreHome")
    public Object home() {
        List<ProductType> productTypes= productTypeMapper.listAll(); //获取所有商品类型集合
        productService.fill(productTypes);  //把获取的商品类型集合通过fill填充函数，对商品类型填充商品集合，商品集合里面每个商品填充first缩略图
        productService.fillByRow(productTypes);
//        categoryService.removeCategoryFromProduct(productTypes);
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


}
