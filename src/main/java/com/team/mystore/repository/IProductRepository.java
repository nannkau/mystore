package com.team.mystore.repository;

import com.team.mystore.entity.Product;

import java.util.Optional;


public interface IProductRepository extends IGenericRepository<Product>  {
    Optional<Product> findById(Long id);
}
