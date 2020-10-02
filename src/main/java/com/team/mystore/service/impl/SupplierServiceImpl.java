package com.team.mystore.service.impl;

import com.team.mystore.dto.SupplierDto;
import com.team.mystore.entity.Supplier;
import com.team.mystore.repository.SupplierRepository;
import com.team.mystore.service.SupplierService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService {
    private  final SupplierRepository supplierRepository;
    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public List<SupplierDto> findAll() {
        List<SupplierDto> supplierDtos= new ArrayList<>();
        for (Supplier supplier:supplierRepository.findAll()){
            ModelMapper modelMapper= new ModelMapper();
            SupplierDto supplierDto=modelMapper.map(supplier,SupplierDto.class);
            supplierDtos.add(supplierDto);
        }
        return supplierDtos;
    }

    @Override
    public Supplier save(SupplierDto supplierDto) {
        ModelMapper modelMapper= new ModelMapper();
        Supplier supplier=modelMapper.map(supplierDto,Supplier.class);
        return supplierRepository.save(supplier);
    }

    @Override
    public void deleteById(Integer id) {
        supplierRepository.deleteById(id);
    }

    @Override
    public SupplierDto findById(Integer id) {
        ModelMapper modelMapper= new ModelMapper();
        SupplierDto supplierDto=modelMapper.map(supplierRepository.findById(id).get(),SupplierDto.class);
        return supplierDto ;
    }

    @Override
    public List<Supplier> findByStatus(String status) {
        return supplierRepository.findByStatus(status);
    }
}
