package com.team.mystore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping(value = {"/","index.html"})
    public String index(){
        return "home";
    }
    @RequestMapping(value = {"/admin**"})
    public String admin(){
        return "admin";
    }

}
