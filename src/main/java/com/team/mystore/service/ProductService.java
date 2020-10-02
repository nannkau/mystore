package com.team.mystore.service;

import com.team.mystore.dto.ProductDto;
import com.team.mystore.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public List<ProductDto> findAll();
    public Product save(ProductDto productDto);
    public void deleteById(Integer id);
    public ProductDto findById(Integer id);

}
