package com.team.mystore.repository;

import com.team.mystore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
   public Product findByProductId(Integer id);
}
