package com.team.mystore.service;

import com.team.mystore.dto.ItemDto;
import com.team.mystore.dto.SearchInvoice;
import com.team.mystore.entity.Invoice;
import com.team.mystore.entity.Role;
import org.attoparser.dom.INode;
import org.springframework.security.core.Authentication;

import java.util.List;
import java.util.Optional;

public interface InvoiceService {
    public List<Invoice> findAll();
    public Invoice save( ItemDto itemDto, Authentication authentication);
    public void deleteById(Integer id);
    public Optional<Invoice> findById(Integer id);
    public List<Invoice> findByDate(SearchInvoice searchInvoice);
    public void setStatus(Integer id,String status);
}
