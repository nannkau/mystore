package com.team.mystore.controller;

import com.team.mystore.entity.Invoice;
import com.team.mystore.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller

public class StatisticalController  {
    @Autowired
    private InvoiceService invoiceService;
    @RequestMapping(value = "/statistical")
    public String chart(Model model){
        List<Invoice> invoiceList =invoiceService.findAll();
        Map<Integer,List<Invoice>> listInvoiceByMonth = new HashMap<>();
        List<Integer> arr = new ArrayList<>();
        int tongdt =0;
        for(int i=1;i<=12;i++){
            List<Invoice> temp = new ArrayList<>();
            int dt =0;
            for(Invoice invoice :invoiceList){
                if(invoice.getCreateDate().getMonth()+1 ==i){
                    temp.add(invoice);
                    dt += invoice.getPriceTotal();
                }
            }
            arr.add(dt);
            tongdt +=dt;
            listInvoiceByMonth.put(i,temp);
        }
        model.addAttribute("tdt",tongdt);
        model.addAttribute("dt",arr);
        model.addAttribute("listInvoiceByMonth",listInvoiceByMonth);
        return "Chart/doanhthu";
    }
    @RequestMapping(value = "/statistical/detail/month/{month}")
    public String detail(Model model, @PathVariable int month){
        List<Invoice> invoiceList =invoiceService.findAll();
        List<Invoice> result = new ArrayList<>();
        int dt = 0;
        for(Invoice invoice :invoiceList){
            if(invoice.getCreateDate().getMonth()+1 ==month){
                result.add(invoice);
                dt += invoice.getPriceTotal();
            }
        }
        model.addAttribute("listInvoiceByMonth",result);
        model.addAttribute("dt",dt);
        model.addAttribute("month",month);

        return "Chart/detail";
    }


}
