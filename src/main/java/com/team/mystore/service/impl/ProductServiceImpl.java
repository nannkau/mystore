package com.team.mystore.service.impl;

import com.team.mystore.entity.Product;
import com.team.mystore.repository.ProductRepository;
import com.team.mystore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteById(Integer id) {
        productRepository.deleteById(Long.parseLong(id.toString()));
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findByProductId(id);
    }
}
