package com.team.mystore.controller;

import com.team.mystore.dto.Item;
import com.team.mystore.dto.ItemDto;
import com.team.mystore.dto.SearchInvoice;
import com.team.mystore.entity.Invoice;
import com.team.mystore.entity.Product;
import com.team.mystore.service.InvoiceService;
import com.team.mystore.service.ProductService;
import com.team.mystore.utils.ExportBill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        Integer count=0;
        for(Item item: itemDto.getItemList()){
            if (item.getSelected()==true){
                count++;
            }
        }
        if (result.hasErrors()|| count==0) {
            List<Product> products= productService.getProductForInvoice(0,"0");
            model.addAttribute("products",products);
            return "invoice/index";
        }
        else {
           Invoice invoice= invoiceService.save(itemDto,authentication);

            return "redirect:/invoice/successful.html/"+(invoice.getInvoiceId()).toString() ;
        }

    }
    @RequestMapping(value = "/invoice/successful.html/{id}")
    public String  successful(Model model, @PathVariable("id") Integer id, HttpServletResponse response) throws IOException {
        Invoice invoice= invoiceService.findById(id).get();
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=bill_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
        ExportBill.export(response,invoice);
        return "redirect:/invoice/add.html";
    }
    @RequestMapping("/admin/invoice/search.html")
    public String search(Model model, @Valid SearchInvoice searchInvoice,BindingResult bindingResult ){
        model.addAttribute("invoices",invoiceService.findByDate(searchInvoice));
        model.addAttribute("searchInvoice",searchInvoice);
        return "invoice/list";
    }
}
