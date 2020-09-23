package com.team.mystore.service;

import com.team.mystore.dto.CategoryDto;
import com.team.mystore.entity.Category;

import java.util.List;


public interface CategoryService {
    public List<CategoryDto> findAll();
    public Category add(Category category);
    public Category update(Category category);
    public void deleteById(Integer id);


}
