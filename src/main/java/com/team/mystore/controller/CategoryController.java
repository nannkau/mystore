package com.team.mystore.controller;

import com.team.mystore.entity.Category;
import com.team.mystore.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/category/index.html")
    public String index(Model model){
        model.addAttribute("categories",categoryService.findAll());
        return "category/index";
    }

    @RequestMapping(value = "/category/add.html")
    public String add(Model model){
        Category category= new Category();
        model.addAttribute("category",category);
        return "category/add";
    }
    @RequestMapping(value = "category/add.html",method = RequestMethod.POST)
    public String add(Category category, Model model, BindingResult result){
        if (result.hasErrors()) {
            return "category/add";
        }
        if(!category.getName().equals("")){
        categoryService.save(category);
        }
        return "redirect:/category/index.html";
    }
    @RequestMapping(value = "/category/edit/{id}")
    public String edit(Model model,@PathVariable("id") Integer id){
        model.addAttribute("category",categoryService.findById(id).get());
        return "category/edit";
    }
}
