package com.team.mystore.service;

import com.team.mystore.entity.Category;

import java.util.List;
import java.util.Optional;


public interface CategoryService {
    public List<Category> findAll();
    public Category save(Category category);
    public void deleteById(Integer id);
    public Optional<Category> findById(Integer id);
    public List<Category> findByStatus(String status);


}
