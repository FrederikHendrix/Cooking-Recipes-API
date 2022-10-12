package com.example.cookinrecipesapi.controller;


import com.example.cookinrecipesapi.entity.category;
import com.example.cookinrecipesapi.entity.recipe;
import com.example.cookinrecipesapi.service.categoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/post/category")
    public String createCategory(@RequestBody category category)
    {
        service.createCategory(category);
        return "New Category Has Been Added";
    }
}
