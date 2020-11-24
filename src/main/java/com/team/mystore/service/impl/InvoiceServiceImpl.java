package com.team.mystore.service.impl;

import com.team.mystore.dto.Item;
import com.team.mystore.dto.ItemDto;
import com.team.mystore.dto.SearchInvoice;
import com.team.mystore.entity.*;
import com.team.mystore.repository.EmployeeRepository;
import com.team.mystore.repository.InvoiceRepository;
import com.team.mystore.repository.ProductRepository;
import com.team.mystore.service.InvoiceService;
import com.team.mystore.utils.DateUtils;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final EmployeeRepository employeeRepository;
    private final ProductRepository productRepository;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, EmployeeRepository employeeRepository, ProductRepository productRepository) {
        this.invoiceRepository = invoiceRepository;
        this.employeeRepository = employeeRepository;
        this.productRepository = productRepository;
    }


    @Override
    public List<Invoice> findAll() {
        return invoiceRepository.findAll() ;
    }

    @Override
    public Invoice save( ItemDto itemDto, Authentication authentication) {
        Employee employee= employeeRepository.findEmployeeByUserName(authentication.getName()).get(0);
        Invoice invoice = new Invoice();
        invoice.setStatus("0");
        invoice.setCreateDate(new Date());
        invoice.setEmployee(employee);
        Consumer consumer= new Consumer();
        consumer=itemDto.getConsumer();
        consumer.setStatus("0");
        invoice.setConsumer(consumer);
        List<InvoiceDetail> invoiceDetails= new ArrayList<>();
        Integer price=0;
       for (Item item: itemDto.getItemList()){
           if(item.getSelected()==true){
               InvoiceDetail invoiceDetail= new InvoiceDetail();
               Product product= productRepository.findById(item.getProductId()).get();
               price=price+(product.getSalePrice()*item.getAmount());
               invoiceDetail.setProduct(product);
               invoiceDetail.setAmount(item.getAmount());
               invoiceDetails.add(invoiceDetail);
           }
       }
       invoice.setPriceTotal(price);
       invoice.setInvoiceDetails(invoiceDetails);
        return invoiceRepository.save(invoice);
    }


    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Optional<Invoice> findById(Integer id) {
        return invoiceRepository.findById(id);
    }

    @Override
    public List<Invoice> findByDate(SearchInvoice searchInvoice) {
        if(searchInvoice.getFormDate()!=null && searchInvoice.getToDate()==null){
            return invoiceRepository.findByDate(searchInvoice.getFormDate(),DateUtils.date2String(new Date(),"yyyy-mm-dd"));
        }
        else {

            if(searchInvoice.getFormDate()!=null && searchInvoice.getToDate()!=null){
                List<Invoice> list=invoiceRepository.findByDate(searchInvoice.getFormDate(),searchInvoice.getFormDate());
                return invoiceRepository.findByDate(searchInvoice.getFormDate(),searchInvoice.getToDate());
            }
            return invoiceRepository.findAll();
        }
    }

    @Override
    public void setStatus(Integer id, String status) {
        Invoice invoice= invoiceRepository.findById(id).get();
        invoice.setStatus(status);
        invoiceRepository.save(invoice);
    }

    @Override
    public Map<String, List<String>> countInvoice() {
        List<String> invoiceList0= new ArrayList<>();
        List<String> invoiceList1= new ArrayList<>();
        List<String> invoiceList2= new ArrayList<>();
        Map<String, List<String>> map= new HashMap<>();
        List<Invoice> invoices= invoiceRepository.findAll();
        for(int i=1;i<13;i++){
            Integer shipping=0;
            Integer delivered=0;
            Integer cancel=0;
            for(Invoice invoice: invoices){
                Calendar cal = Calendar.getInstance();
                cal.setTime(invoice.getCreateDate());
                int month = cal.get(Calendar.MONTH)+1;
                if(month==i){
                    if(invoice.getStatus().equals("0")){
                        shipping++;
                    }
                    if(invoice.getStatus().equals("1")){
                        delivered++;
                    }
                    if(invoice.getStatus().equals("2")){
                        cancel++;
                    }
                }
            }
            invoiceList0.add(String.valueOf(shipping));
            invoiceList1.add(String.valueOf(delivered));
            invoiceList2.add(String.valueOf(cancel));


        }
        map.put("shipping",invoiceList0);
        map.put("delivered",invoiceList1);
        map.put("cancel",invoiceList2);
        return map;
    }


}
