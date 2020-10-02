package com.team.mystore.service;


import com.team.mystore.dto.SupplierDto;
import com.team.mystore.entity.Supplier;

import java.util.List;
import java.util.Optional;

public interface SupplierService {
    public List<SupplierDto> findAll();
    public Supplier save(SupplierDto supplierDto);
    public void deleteById(Integer id);
    public SupplierDto findById(Integer id);
    public List<Supplier> findByStatus(String status);
}
