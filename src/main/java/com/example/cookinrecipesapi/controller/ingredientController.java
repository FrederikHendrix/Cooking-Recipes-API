package com.example.cookinrecipesapi.controller;

import com.example.cookinrecipesapi.entity.ingredient;
import com.example.cookinrecipesapi.service.ingredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ingredientController {
    @Autowired
    private ingredientService service;

    @PostMapping("/post/ingredients")
    public String createIngredients(@RequestBody List<ingredient> ingredients)
    {
        service.createIngredients(ingredients);
        return "Ingredients have been Added to Recipe";
    }

    @GetMapping("get/ingredients/{recipeid}")
    public List<ingredient> getIngredientsFromRecipeId(@PathVariable int recipeid){return service.getIngredientsFromRecipeId(recipeid);}
}
