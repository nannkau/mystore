package com.team.mystore.service.impl;
import com.team.mystore.dto.CategoryDto;
import com.team.mystore.entity.Category;
import com.team.mystore.repository.CategoryRepository;
import com.team.mystore.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDto> findAll() {
        List<Category> list=categoryRepository.findAll();
        List<CategoryDto> categoryDtoList= new ArrayList<>();
        for (Category category:list) {
            ModelMapper modelMapper = new ModelMapper();
            CategoryDto categoryDto = modelMapper.map(category, CategoryDto.class);
            categoryDtoList.add(categoryDto);
        }
        return categoryDtoList;
    }

    @Override
    public Category add(Category category) {
       return categoryRepository.save(category);
    }

    @Override
    public Category update(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteById(Integer id) {
        categoryRepository.deleteById(id);
    }


}
