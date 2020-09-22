package com.team.mystore.repository.impl;

import com.team.mystore.entity.Product;
import com.team.mystore.repository.AbstractJpaRepository;
import com.team.mystore.repository.IProductRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ProductRepositoryImpl extends AbstractJpaRepository<Product> implements IProductRepository {
}
