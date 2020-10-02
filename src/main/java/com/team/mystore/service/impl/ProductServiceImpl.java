package com.team.mystore.service.impl;

import com.team.mystore.dto.ProductDto;
import com.team.mystore.dto.SupplierDto;
import com.team.mystore.entity.Product;
import com.team.mystore.entity.Supplier;
import com.team.mystore.repository.ProductRepository;
import com.team.mystore.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl( ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public List<ProductDto> findAll() {
        List<ProductDto> productDtos= new ArrayList<>();
        for (Product product:productRepository.findAll()){
            ModelMapper modelMapper= new ModelMapper();
            ProductDto  productDto=modelMapper.map(product,ProductDto.class);
            productDtos.add(productDto);
        }
        return productDtos;
    }

    @Override
    public Product save(ProductDto productDto) {
        ModelMapper modelMapper= new ModelMapper();
        Product product=modelMapper.map(productDto,Product.class);
        return productRepository.save(product);
    }

    @Override
    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductDto findById(Integer id) {
        ModelMapper modelMapper= new ModelMapper();
        ProductDto productDto=modelMapper.map(productRepository.findById(id).get(),ProductDto.class);
        return productDto ;
    }
}
