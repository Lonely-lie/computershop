package com.example.computershop.pagecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


//注解 返回JSON数据的Controller
@Controller
public class AdminController {

  //注解：设置浏览器访问服务器的url

  @RequestMapping("/hello")
  public String sayHello() {
    return "test/test";
  }

  @GetMapping(value="/admin")
  public String admin(){
    return "redirect:admin_type_list";  //重定向
  }

  @RequestMapping("/admin_type_list")
  public String listtype() {
    return "admin/admin_type_list";
  }

  @GetMapping("/admin_property_list")
  public String listProperty(){
    return "admin/admin_property_list";
  }
}
