package com.example.cookinrecipesapi.controller;

import com.example.cookinrecipesapi.entity.recipe;
import com.example.cookinrecipesapi.service.recipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class recipeController {
    @Autowired
    private recipeService service;

    @GetMapping("/get/recipes")
    public List<recipe> getAllRecipes()
    {
        return service.getAllRecipes();
    }

    @PostMapping("/post/recipe")
    public String createRecipe(@RequestBody recipe recipe)
    {
        service.createRecipe(recipe);
        return "New Recipe Has Been Added";
    }
}
