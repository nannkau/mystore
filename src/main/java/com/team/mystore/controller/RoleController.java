package com.team.mystore.controller;

import com.team.mystore.entity.Role;
import com.team.mystore.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class RoleController {
    private final RoleService roleService;
    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @RequestMapping(value = "/admin/role/index.html")
    public String index(Model model){
        model.addAttribute("roles",roleService.findAll());
        return "role/index";
    }

    @RequestMapping(value = "/admin/role/add.html")
    public String add(Model model){
        Role role= new Role();
        model.addAttribute("role",role);
        return "role/add";
    }
    @RequestMapping(value = "/admin/role/add.html",method = RequestMethod.POST)
    public String add(@Valid Role role, BindingResult result){
        if (result.hasErrors()) {
            return "role/add";
        }
        else {
            roleService.save(role);
        }
        return "redirect:/admin/role/index.html";
    }
    @RequestMapping(value = "/admin/role/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id){
        Role role=roleService.findById(id).get();
        model.addAttribute("role",role);
        return "role/edit";
    }
    @RequestMapping(value = "/admin/role/delete/{id}")
    public String delete(Model model,@PathVariable("id") Integer id){

        roleService.deleteById(id);
        return "redirect:/admin/role/index.html";
    }
}
