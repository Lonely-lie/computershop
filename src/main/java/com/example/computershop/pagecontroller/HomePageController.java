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
}

