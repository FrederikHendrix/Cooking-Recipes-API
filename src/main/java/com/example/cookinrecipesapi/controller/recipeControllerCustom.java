package com.example.cookinrecipesapi.controller;

import com.example.cookinrecipesapi.entity.recipe;
import com.example.cookinrecipesapi.service.recipeService;
import com.example.cookinrecipesapi.service.recipeServiceCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class recipeControllerCustom {
    @Autowired
    private recipeServiceCustom service;

    @GetMapping("/get/recipeid/{title}")
    public int getRecipeIdFromTitle(@PathVariable String title)
    {
        return service.getRecipeIdFromTitle(title);
    }
}
