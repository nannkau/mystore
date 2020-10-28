package com.team.mystore.controller;

import com.team.mystore.dto.EmployeeDto;
import com.team.mystore.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
        model.addAttribute("em",em);
        return "employee/Add";
    }
}
