package com.team.mystore.service;

import com.team.mystore.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public List<Product> findAll();
    public Product save(Product product);
    public void deleteById(Integer id);
    public Product findById(Integer id);

}
