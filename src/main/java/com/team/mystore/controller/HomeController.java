package com.team.mystore.controller;

import com.team.mystore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    UserRepository userRepository;
    @RequestMapping(value = {"/","index.html"})
    public String index(){
        userRepository.findByusername("tuangh");
        return "home";
    }
    @RequestMapping(value = {"/admin"})
    public String admin(){
        return "admin";
    }

    @RequestMapping(value = {"/staff"})
    public String user(){
        UserDetails user =(UserDetails) (SecurityContextHolder.getContext().getAuthentication()).getPrincipal();
        user.getUsername();
        return "user";
    }
    @RequestMapping(value = {"/accessdenied"})
    public String accessdenied(){
        return "accessdenied";
    }
    @RequestMapping(value = {"/login"})
    public String login(){
        return "login";
    }



}
