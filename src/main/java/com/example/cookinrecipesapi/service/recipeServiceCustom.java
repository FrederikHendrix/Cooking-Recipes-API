package com.example.cookinrecipesapi.service;

import com.example.cookinrecipesapi.entity.recipe;
import org.springframework.stereotype.Service;
import com.example.cookinrecipesapi.repository.recipeRepositoryCustom;

import java.util.List;

@Service
public class recipeServiceCustom {

    private final recipeRepositoryCustom recipeRepositoryCustom;

    public recipeServiceCustom(com.example.cookinrecipesapi.repository.recipeRepositoryCustom recipeRepositoryCustom)
    {
        this.recipeRepositoryCustom = recipeRepositoryCustom;
    }

    public int getRecipeIdFromTitle(String title)
    {
        return recipeRepositoryCustom.getRecipeIdFromTitle(title);
    }
}
