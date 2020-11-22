package com.team.mystore.controller;


import com.team.mystore.dto.*;
import com.team.mystore.entity.Product;
import com.team.mystore.entity.Recevie;
import com.team.mystore.entity.Supplier;
import com.team.mystore.service.ProductService;
import com.team.mystore.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class InventoryController {
    private final ProductService productService;
    private final SupplierService supplierService;
    @Autowired
    public InventoryController(ProductService productService,SupplierService supplierService){
        this.productService =productService;
        this.supplierService=supplierService;

    }
    @RequestMapping(value = "/inventory/index.html")
    public String index(Model model) {
        //InventoryDTO inventoryDTO = new InventoryDTO();
        List<SupplierDto> suppliers= supplierService.findAll();
        model.addAttribute("suppliers",suppliers);
        List<Product> products = productService.getProductForInvoice(2,"0");
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
            inventoryItems.add(new inventoryItem(p.getProductId(),0,0));
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
    public String add(Model model,InventoryDTO inventoryDTOS, Authentication authentication, BindingResult result ){

            return null;

    }

    @RequestMapping(value ="/inventory/product",method = RequestMethod.POST)
    public List<Product> getProductForinventory(@RequestParam int supplier_id){
        return productService.findProductBySupplier(supplier_id,"0");
    }

}
