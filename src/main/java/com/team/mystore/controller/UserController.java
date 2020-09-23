package com.team.mystore.controller;

import com.team.mystore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/admin/user.html")
    public String index(Model model){
        model.addAttribute("users",userService.findAll());
        return "admin/user";
    }
}
