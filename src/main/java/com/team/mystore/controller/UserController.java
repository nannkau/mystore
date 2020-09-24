package com.team.mystore.controller;

import com.team.mystore.dto.UserDto;
import com.team.mystore.entity.User;
import com.team.mystore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    @RequestMapping(value = "/admin/user/add.html")
    public String add(Model model){
        UserDto userDto= new UserDto();
        model.addAttribute("userDto",userDto);
        return "admin/add";
    }
    @RequestMapping(value = "/admin/add.html",method = RequestMethod.POST)
    public String add(UserDto userDto, Model model, BindingResult result){
        if (result.hasErrors()) {
            return "admin/add";
        }
        if(!userDto.getUserName().equals("")){
            userService.add(userDto);
        }
        return "redirect:admin/user.html";
    }
}
