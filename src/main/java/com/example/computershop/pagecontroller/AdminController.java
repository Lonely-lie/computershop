package com.example.computershop.pagecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//注解 返回JSON数据的Controller
@Controller
public class AdminController {

  //注解：设置浏览器访问服务器的url

  @RequestMapping("/hello")
  public String sayHello() {
    return "test/test";
  }
  @RequestMapping("/admin")
  public String admin() {
    return "admin/admin_category_list";
  }
}
