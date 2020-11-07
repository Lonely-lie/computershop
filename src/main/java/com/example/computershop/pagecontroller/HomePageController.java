package com.example.computershop.pagecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomePageController {
    @GetMapping(value="/")
    public String index(){
        return "redirect:home";
    }
    @GetMapping(value="/home")
    public String home(){
        return "homePage/homePage";
    }
    @GetMapping("/register")
    public String register(){
        return "homePage/register";
    }
    @GetMapping(value="/registerSuccess")
    public String registerSuccess(){
        return "homePage/registerSuccess";
    }

    @GetMapping(value="/login")
    public String login(){
        return "homePage/login";
    }
    @GetMapping("/foreLogout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:home";
    }
    @GetMapping(value="/product")
    public String product(){
        return "homePage/product";
    }
    @GetMapping(value="/category")
    public String category(){
        return "homePage/category";
    }
    @GetMapping(value="/search")//搜索页面
    public String searchResult(){
        return "homePage/foreSearch";
    }
    @GetMapping(value="/buy")//立即购买页面
    public String buy(){
        return "homePage/buy";
    }
    @GetMapping(value="/cart")
    public String cart(){
        return "homePage/cart";
    }
    @GetMapping(value="/alipay")
    public String alipay(){
        return "homePage/alipay";
    }

    @GetMapping(value="/payed")//确认支付页面跳转
    public String payed(){
        return "homePage/payed";
    }

    @GetMapping(value="/bought")
    public String bought(){
        return "homePage/bought";
    }

    @GetMapping(value="/confirmPay")
    public String confirmPay(){
        return "homePage/confirmPay";
    }

    @GetMapping(value="/orderConfirmed")
    public String orderConfirmed(){
        return "homePage/orderConfirmed";
    }
}

