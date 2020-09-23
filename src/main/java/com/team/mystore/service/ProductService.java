package com.team.mystore.service;

import com.team.mystore.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
}
