package com.team.mystore.controller;

import com.team.mystore.dto.SupplierDto;
import com.team.mystore.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class SupplierController {
    private SupplierService supplierService;
    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }
    @RequestMapping(value = "/supplier/index.html")
    public String index(Model model){
        model.addAttribute("supplierDtos",supplierService.findAll());
        return "supplier/index";
    }

    @RequestMapping(value = "/supplier/add.html")
    public String add(Model model){
        SupplierDto supplierDto= new SupplierDto();
        model.addAttribute("supplierDto",supplierDto);
        return "supplier/add";
    }
    @RequestMapping(value = "supplier/add.html",method = RequestMethod.POST)
    public String add(@Valid SupplierDto supplierDto, BindingResult result){
        if (result.hasErrors()) {
            return "supplier/add";
        }
        else {
            supplierService.save(supplierDto);
        }
        return "redirect:/supplier/index.html";
    }
    @RequestMapping(value = "/supplier/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id){
        model.addAttribute("supplierDto",supplierService.findById(id));
        return "supplier/edit";
    }
}
