package com.team.mystore.service;

import com.team.mystore.dto.ProductDto;
import com.team.mystore.entity.Product;

import java.util.List;

public interface ProductService {
    public List<ProductDto> findAll();
    public Product save(ProductDto productDto);
    public void deleteById(Integer id);
    public ProductDto findById(Integer id);
    public Product findProductById(Integer id);
    public List<Product> getProductForInvoice(Integer number,String status);

}
