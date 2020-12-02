package com.team.mystore.controller;


import com.team.mystore.dto.*;
import com.team.mystore.entity.Product;
import com.team.mystore.entity.Recevie;
import com.team.mystore.entity.RecevieDetail;
import com.team.mystore.service.InventoryService;
import com.team.mystore.service.ProductService;
import com.team.mystore.service.SupplierService;
import com.team.mystore.utils.ExportBill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class InventoryController {
    private final ProductService productService;
    private final SupplierService supplierService;
    private  final InventoryService inventoryService;
    //private  final
    @Autowired
    public InventoryController(ProductService productService,SupplierService supplierService,InventoryService inventoryService){
        this.productService =productService;
        this.supplierService=supplierService;
        this.inventoryService =inventoryService;

    }
    @RequestMapping(value = "/inventory/index.html")
    public String index(Model model, @Valid ListInventory searchRecevie,BindingResult bindingResult) {
       model.addAttribute("recivies",inventoryService.findByDate(searchRecevie));
       model.addAttribute("searchRecive",searchRecevie);
        return "inventory/index";
    }

    @RequestMapping(value ="/inventory/add.html",method = RequestMethod.GET)
    public  String add(Model model , HttpServletRequest request){
        String param = request.getParameter("supplier_id");

        List<SupplierDto> suppliers= supplierService.findAll();
        model.addAttribute("suppliers",suppliers);
        int id =suppliers.get(0).getSupplierId();
        if(param !=null){
            id=Integer.valueOf(param);
        }

        List<Product> products = productService.findProductBySupplier(id,"0");
        InventoryDTO inventoryDTOS =new InventoryDTO();
        List<inventoryItem> inventoryItems =new ArrayList<>();
        for(Product p:products)
        {
            inventoryItem inventoryItem = new inventoryItem();
            inventoryItem.setProduct_id(p.getProductId());
            inventoryItem.setSoLuong(0);
            inventoryItem.setTongtien(0);
            inventoryItem.setPrice(0);
            inventoryItems.add(inventoryItem);
        }
        inventoryDTOS.setInventoryItems(inventoryItems);
        model.addAttribute("inventoryDTOS",inventoryDTOS);
        model.addAttribute("products",products);
        Recevie recevie = new Recevie();
        inventoryDTOS.setRecevie(recevie);
        model.addAttribute("supplier_id",id);
        return "inventory/add";
    }
    @RequestMapping(value ="/inventory/add.html",method = RequestMethod.POST)
    public String add(Model model,@Valid InventoryDTO inventoryDTOS, Authentication authentication, BindingResult result ){
        if(result.hasErrors())
        {
            return "redirect:/inventory/add.html";
        }else{
            try{
                inventoryService.addRecevie(inventoryDTOS,authentication);
                return "redirect:/inventory/index.html";
            }catch (Exception e){
                return "redirect:/inventory/add.html";
            }
        }

    }

//    @RequestMapping(value ="/inventory/product",method = RequestMethod.POST)
//    public List<Product> getProductForinventory(@RequestParam int supplier_id){
//        return productService.findProductBySupplier(supplier_id,"0");
//    }
    @RequestMapping(value = "/inventory/recevie/{id}")
    public String detail(Model model,@PathVariable int id){

        model.addAttribute("recevie",inventoryService.findRecevieById(id));
        return "inventory/detail";
    }
    @RequestMapping(value = "/inventory/edit/{id}")
    public String edit(Model model,@PathVariable int id){
        Recevie recevie = inventoryService.findRecevieById(id);
        InventoryDTO inventoryDTO =new InventoryDTO();
        List<inventoryItem> inventoryItems =new ArrayList<>();

        for(RecevieDetail recevieDetail : recevie.getRecevieDetails()){
            inventoryItem inventoryItem = new inventoryItem();
            inventoryItem.setProduct_id(recevieDetail.getProduct().getProductId());
            inventoryItem.setSoLuong(recevieDetail.getAmountTotal());
            inventoryItem.setTongtien(0);
            inventoryItems.add(inventoryItem);
        }
        inventoryDTO.setRecevie(recevie);
        inventoryDTO.setInventoryItems(inventoryItems);
        model.addAttribute("inventoryDTO",inventoryDTO);
        model.addAttribute("recevie",recevie);
        return "inventory/edit";
    }
    @RequestMapping(value = "/inventory/edit.html",method = RequestMethod.POST)
    public String edit(Model model ,Recevie recevie,InventoryDTO inventoryDTO,BindingResult bindingResult){

        if(bindingResult.hasErrors())
        {
            return "redirect:/inventory/edit/"+recevie.getReceiveId();

        }else{
            try{
                //todo
                inventoryService.edit(recevie);
                return "redirect:/inventory/index.html";
            }catch (Exception e){
                return "redirect:/inventory/edit/"+recevie.getReceiveId();
            }
        }
    }
    @RequestMapping(value = "/inventory/print/{id}")
    public String printRecevie(@PathVariable int id, HttpServletResponse response){
        try{
            Recevie recevie = inventoryService.findRecevieById(id);
            response.setContentType("application/pdf");
            DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
            String currentDateTime = dateFormatter.format(new Date());
            String headerKey = "Content-Disposition";
            String headerValue = "attachment; filename=recevie_" + currentDateTime + ".pdf";
            response.setHeader(headerKey, headerValue);
            ExportBill.exportRecevie(response,recevie);
            return "redirect:/inventory/index.html";
        }catch (Exception e){
            return "redirect:/inventory/index.html";

        }
    }
    @RequestMapping(value = "/inventory/product/saphethang")
    public String sphh(Model model){
        List<ProductDto> products = productService.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        for(ProductDto productDto:products){
            if(productDto.getAmountTotal()<5)
            {
                productDtos.add(productDto);
            }
        }
        model.addAttribute("sp",productDtos);
        return "inventory/saphethang";
    }

}
