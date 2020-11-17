package com.team.mystore.service.impl;

import com.team.mystore.dto.Item;
import com.team.mystore.dto.ItemDto;
import com.team.mystore.entity.*;
import com.team.mystore.repository.EmployeeRepository;
import com.team.mystore.repository.InvoiceRepository;
import com.team.mystore.repository.ProductRepository;
import com.team.mystore.service.InvoiceService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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
               price=price+(product.getPrice()*item.getAmount());
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


}
