package com.example.cookinrecipesapi.controller;


import com.example.cookinrecipesapi.entity.category;
import com.example.cookinrecipesapi.service.categoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class categoryController {
    @Autowired
    private categoryService service;

    @GetMapping("/get/categories")
    public List<category> findAllCategories()
    {
        return service.getCategory();
    }
}
