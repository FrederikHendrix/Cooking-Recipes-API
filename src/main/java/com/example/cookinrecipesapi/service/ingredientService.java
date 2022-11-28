package com.example.cookinrecipesapi.service;

import com.example.cookinrecipesapi.entity.ingredient;
import com.example.cookinrecipesapi.repository.ingredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ingredientService {
    private final ingredientRepository ingredientRepository;

    public ingredientService(com.example.cookinrecipesapi.repository.ingredientRepository ingredientRepository)
    {
        this.ingredientRepository = ingredientRepository;
    }

    public List<ingredient> createIngredients(List<ingredient> ingredients)
    {
        return ingredientRepository.saveAll(ingredients);
    }

    public String deleteIngredients(int recipeid)
    {
        ingredientRepository.deleteByRecipeid(recipeid);
        return "ingredients have been deleted";
    }

    public List<ingredient> getIngredientsFromRecipeId(int recipeid){return ingredientRepository.findByRecipeid(recipeid);}
}
