package com.example.cookinrecipesapi.controller;

import com.example.cookinrecipesapi.entity.recipe;
import com.example.cookinrecipesapi.exception.RequestException;
import com.example.cookinrecipesapi.service.recipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class recipeController {
    @Autowired
    private recipeService service;

    @GetMapping(value = "/get/recipes")
    public List<recipe> getAllRecipes()
    {
        try
        {
            return service.getAllRecipes();
        }
        catch (Exception e)
        {
            throw new RequestException("Couldn't find all recipes");
        }

    }

    @PostMapping("/post/recipe")
    public String createRecipe(@RequestBody recipe recipe)
    {
        try
        {
            service.createRecipe(recipe);
            return "New Recipe Has Been Added";
        }
        catch (Exception e)
        {
            throw new RequestException("Couldn't create recipe");
        }

    }

    @DeleteMapping("/delete/{id}")
    public String deleteRecipe(@PathVariable int id){

        try
        {
            String messageRecipe = service.deleteRecipeById(id);
            return  messageRecipe;
        }
        catch(Exception e)
        {
            throw new RequestException("Couldn't delete recipe by id");
        }

    }

    @PutMapping("/recipe/update")
    public recipe updateRecipe(@RequestBody recipe recipe)
    {
        try
        {
            return service.updateRecipe(recipe);
        }
        catch(Exception e)
        {
            throw new RequestException("Couldn't Update Recipe");
        }

    }

    @GetMapping("get/recipe/{id}")
    public recipe getRecipeById(@PathVariable int id){
        try
        {
            return service.findById(id);
        }
        catch(Exception e)
        {
            throw new RequestException("Couldn't find the recipe by id");
        }

    }

    @GetMapping("/get/recipes/{categoryid}")
    public List<recipe> getRecipesByCategoryId(@PathVariable int categoryid){
        try
        {
            return service.getRecipesByCategoryId(categoryid);
        }
        catch(Exception e)
        {
            throw new RequestException("Couldn't find products with categoryId");
        }

    }

    @GetMapping("/get/recipeid/{title}")
    public int getRecipeIdFromTitle(@PathVariable String title)
    {
        try
        {
            return service.getRecipeIdFromTitle(title);
        }
        catch(Exception e) {
            throw new RequestException("Couldn't find recipe with title");
        }
    }
}
