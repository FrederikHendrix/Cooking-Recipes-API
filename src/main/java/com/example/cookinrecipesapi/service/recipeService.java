package com.example.cookinrecipesapi.service;

import com.example.cookinrecipesapi.entity.recipe;
import org.springframework.stereotype.Service;
import com.example.cookinrecipesapi.repository.recipeRepository;

import java.util.List;

@Service
public class recipeService {

    private final recipeRepository recipeRepository;

    public recipeService(com.example.cookinrecipesapi.repository.recipeRepository recipeRepository)
    {
        this.recipeRepository = recipeRepository;
    }

    public List<recipe> getAllRecipes()
    {
        return recipeRepository.findAll();
    }

    public List<recipe> getRecipesByCategoryId(int categoryid){return recipeRepository.findByCategoryid(categoryid);}

    public recipe createRecipe(recipe recipe)
    {
        return recipeRepository.save(recipe);
    }

    public int getRecipeIdFromTitle(String title)
    {
        return recipeRepository.getRecipeIdFromTitle(title);
    }

    public recipe findById(int id){return recipeRepository.findById(id);}
}
