package com.team.mystore.controller;

import com.team.mystore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    UserRepository userRepository;
    @RequestMapping(value = {"/","index.html"})
    public String index(){
        return "home";
    }
    @RequestMapping(value = {"/admin"})
    public String admin(Model model){
        UserDetails user =(UserDetails) (SecurityContextHolder.getContext().getAuthentication()).getPrincipal();
        user.getUsername();
        //model.addAttribute("messages", user.getUsername());

        return  "redirect:/index.html?q="+user.getUsername();
    }

    @RequestMapping(value = {"/staff"})
    public String user(Model model){
        UserDetails user =(UserDetails) (SecurityContextHolder.getContext().getAuthentication()).getPrincipal();
        user.getUsername();
        //model.addAttribute("messages", user.getUsername());

        return  "redirect:/index.html?q="+user.getUsername();
    }
    @RequestMapping(value = {"/seller"})
    public String seller(Model model){
        UserDetails user =(UserDetails) (SecurityContextHolder.getContext().getAuthentication()).getPrincipal();
        user.getUsername();
        //model.addAttribute("messages", user.getUsername());

        return  "redirect:/index.html?q="+user.getUsername();
    }
    @RequestMapping(value = {"/accessdenied"})
    public String accessdenied(){
        return "accessdenied";
    }


}
