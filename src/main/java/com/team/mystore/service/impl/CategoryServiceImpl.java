package com.team.mystore.service.impl;
import com.team.mystore.entity.Category;
import com.team.mystore.repository.CategoryRepository;
import com.team.mystore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {

        return categoryRepository.findAll();
    }

    @Override
    public Category save(Category category) {
       return categoryRepository.save(category);
    }

    @Override
    public void deleteById(Integer id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return categoryRepository.findById(id);
    }

    @Override
    public List<Category> findByStatus(String status) {
        return categoryRepository.findByStatus(status);
    }


}
