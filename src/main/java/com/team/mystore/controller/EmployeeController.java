package com.team.mystore.controller;

import com.team.mystore.dto.EmployeeDto;
import com.team.mystore.entity.Employee;
import com.team.mystore.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller()
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/admin/employee.html")
    public String employee(Model model){
        model.addAttribute("employees",employeeService.findEmployeeActive());
        return "employee/employee";
    }

    @RequestMapping(value = "/admin/employee/add.html")
    public String add(Model model){
        EmployeeDto em =new EmployeeDto();
        model.addAttribute("employeeDto",em);
        return "employee/Add";
    }
    @RequestMapping(value = "/admin/employee/add.html",method = RequestMethod.POST)
    public String add(@Valid EmployeeDto employee, BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()) {
            return "employee/Add";
        }
        else {
                employeeService.add(employee);
        }
        return "redirect:/admin/employee.html";
    }
    @RequestMapping(value = "/admin/employee/edit.html")
    public String edit(Model model, @RequestParam int id){
        ModelMapper modelMapper = new ModelMapper();
        EmployeeDto em = modelMapper.map(employeeService.finEmployeeById(id),EmployeeDto.class);
        model.addAttribute("employeeDto",em);
        return "employee/edit";
    }
    @RequestMapping(value = "/admin/employee/delete.html")
    public String edit( @RequestParam int id){

        employeeService.deleteById(id);
        return  "redirect:/admin/employee.html";
    }
}
