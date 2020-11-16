package com.team.mystore.controller;

import com.team.mystore.dto.Item;
import com.team.mystore.dto.ItemDto;
import com.team.mystore.entity.Product;
import com.team.mystore.service.InvoiceService;
import com.team.mystore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class InvoiceController {
    private  final ProductService productService;
   private  final InvoiceService invoiceService;
    @Autowired
    public InvoiceController(ProductService productService, InvoiceService invoiceService) {
        this.productService = productService;
        this.invoiceService = invoiceService;
    }


    @RequestMapping(value = "/invoice/add.html",method = RequestMethod.GET)
    public String add(Model model){
        List<Product> products= productService.getProductForInvoice(0,"0");
        model.addAttribute("products",products);
        List<Item> items= new ArrayList<>();
        for (Product product: products){
            Item item= new Item();
            item.setProductId(product.getProductId());
            item.setSelected(false);
            items.add(item);
        }
        ItemDto itemDto= new ItemDto();
        itemDto.setItemList(items);
        model.addAttribute("itemDto",itemDto);
        return "invoice/index";
    }
    @RequestMapping(value = "/invoice/add.html",method = RequestMethod.POST)
    public String add(Model model, @Valid ItemDto itemDto, Authentication authentication, BindingResult result){
        if (result.hasErrors()) {
            return "invoice/index";
        }
        else {
            invoiceService.save(itemDto,authentication);
        }
        return "redirect:/invoice/successful.html/" ;
    }
    @RequestMapping(value = "/invoice/successful.html/{id}")
    public String successful(Model model,@PathVariable("id") Integer id){

        return "invoice/successful";
    }
}
