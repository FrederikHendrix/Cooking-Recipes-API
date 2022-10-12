package com.example.cookinrecipesapi.service;

import com.example.cookinrecipesapi.entity.category;
import com.example.cookinrecipesapi.repository.categoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class categoryService {

    private final categoryRepository categoryRepository;

    public categoryService(com.example.cookinrecipesapi.repository.categoryRepository categoryRepository)
    {
        this.categoryRepository = categoryRepository;
    }

    public List<category> getCategory()
    {
        return categoryRepository.findAll();
    }

    public category createCategory(category category){
        return categoryRepository.save(category);
    }
}
