package com.team.mystore.controller;

import com.team.mystore.Command.ProductCommand;
import com.team.mystore.Command.UserCommand;
import com.team.mystore.entity.Employee;
import com.team.mystore.entity.User;
import com.team.mystore.service.EmployeeService;
import com.team.mystore.service.RoleService;
import com.team.mystore.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private final UserService userService;
    private final RoleService roleService;
    private final EmployeeService employeeService;

    public UserController(UserService userService, RoleService roleService, EmployeeService employeeService) {
        this.userService = userService;
        this.roleService=roleService;
        this.employeeService=employeeService;
    }

    @RequestMapping(value = "/admin/user.html")
    public String index(Model model){
        model.addAttribute("users",userService.findAll());
        return "admin/user";
    }
    @RequestMapping(value = "/admin/user/add.html")
    public String add(Model model){
        UserCommand command= new UserCommand();
        model.addAttribute("roles",roleService.findByFlagDelete("0"));
        model.addAttribute("employees",employeeService.findEmployeeNotExistAccount());
        model.addAttribute("items",command);
        return "admin/add";
    }
    @RequestMapping(value = "/admin/user/add.html",method = RequestMethod.POST)
    public String add(UserCommand userCommand, Model model, BindingResult result){
        if (result.hasErrors()) {
            return "/admin/user/add.html";
        }
        try{
            User user = new User();
            user = userCommand.getPojo();
            userService.add(user);
        }catch (Exception e){
            return "redirect:/admin/user/add.html?error=can_not_insert";
        }


        return "redirect:/admin/user.html?success=insert_success";
    }
    }
        return "redirect:/admin/user.html?success=edit_success";
            userService.update(userCommand.getPojo());
        }
            System.out.println(userCommand.getPojo());
    @RequestMapping(value = "/admin/user/edit.html")
    public String edit(Model model,@RequestParam("id") Integer id){
        UserCommand command= new UserCommand();
        command.setPojo(userService.findById(id));
        command.getPojo().setPassword("");
        model.addAttribute("roles",roleService.findByFlagDelete("0"));
        return "admin/edit";
        List<Employee> employees =  employeeService.findEmployeeNotExistAccount();
        employees.add((command.getPojo().getEmployee()));
        model.addAttribute("employees",employees);
        System.out.println(command.getPojo());
        model.addAttribute("items",command);
    }
    @RequestMapping(value = "/admin/user/edit.html",method = RequestMethod.POST)
}
