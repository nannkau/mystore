package com.team.mystore.service.impl;

import com.team.mystore.entity.Product;
import com.team.mystore.repository.IProductRepository;
import com.team.mystore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final IProductRepository productRepository;

    @Autowired
    public ProductServiceImpl( IProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
