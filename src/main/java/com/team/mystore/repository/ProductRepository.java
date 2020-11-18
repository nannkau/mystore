package com.team.mystore.repository;

import com.team.mystore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    public List<Product> getProductByAmountTotalGreaterThanAndStatusEquals(Integer number,String status );
}
