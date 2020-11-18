package com.team.mystore.controller;

import com.team.mystore.Command.ProductCommand;
import com.team.mystore.dto.ProductDto;
import com.team.mystore.entity.Product;
import com.team.mystore.service.CategoryService;
import com.team.mystore.service.ProductService;
import com.team.mystore.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
public class ProductController {


    private final ProductService productService;
    private final CategoryService categoryService;
    private final SupplierService supplierService;
    @Autowired
    public ProductController(ProductService productService, CategoryService categoryService, SupplierService supplierService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.supplierService = supplierService;
    }


    @RequestMapping(value = "/product/index.html")
    public String index(Model model){
        model.addAttribute("products",productService.findAll());
        return "product/index";
    }

    @RequestMapping(value = "product/add.html")
    public String add(Model model){
        ProductDto productDto= new ProductDto();
        model.addAttribute("categories",categoryService.findByStatus("0"));
        model.addAttribute("suppliers",supplierService.findByStatus("0"));
        model.addAttribute("productDto",productDto);
        return "product/add";
    }
    @RequestMapping(value = "product/add.html",method = RequestMethod.POST)
    public String add(@Valid ProductDto productDto, BindingResult result) throws IOException {
        if (result.hasErrors()) {
            return "product/add";
        }

        else {

            productService.save(productDto);
        }


        return "redirect:/product/index.html";
    }
    @RequestMapping(value = "/product/edit/{id}")
    public String edit(Model model,@PathVariable("id") Integer id){
        model.addAttribute("categories",categoryService.findByStatus("0"));
        model.addAttribute("suppliers",supplierService.findByStatus("0"));
        model.addAttribute("productDto",productService.findById(id));
        return "product/edit";
    }



}
