package com.team.mystore.repository;

import com.team.mystore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    public List<Product> getProductByAmountTotalGreaterThanAndStatusEquals(Integer number,String status );
    @Query(value = "SELECT * FROM product p WHERE p.supplier_id=?1 AND p.status = ?2",nativeQuery = true)
    public List<Product> findBySupplierAndStatus(int supplier_id ,String status);
}
