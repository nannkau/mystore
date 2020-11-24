package com.team.mystore.controller;

import com.team.mystore.entity.Invoice;
import com.team.mystore.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
     private InvoiceRepository invoiceRepository;
    @RequestMapping(value = "/statistical/getdata")
    public HashMap<String, List<Integer>>getdata() {
        HashMap<String, List<Integer>> map = new HashMap<>();
       List<Invoice> invoices= invoiceRepository.findAll();
        List<Integer> arr = new ArrayList<>();
        for(int i=1;i<=12;i++){
            int temp =0;
            for(Invoice invoice :invoices){
                if(invoice.getCreateDate().getMonth()+1 ==i){
                    temp += invoice.getPriceTotal();
                }
            }
            arr.add(temp);
        }
        map.put("data", arr);
        return map;
    }
}
