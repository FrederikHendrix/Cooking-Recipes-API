package com.example.cookinrecipesapi.service;

import com.example.cookinrecipesapi.entity.recipe;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.example.cookinrecipesapi.repository.recipeRepository;
import com.example.cookinrecipesapi.exception.RequestException;

import java.util.List;

@Component
public class recipeService {

    private final recipeRepository recipeRepository;

    public recipeService(com.example.cookinrecipesapi.repository.recipeRepository recipeRepository)
    {
            this.recipeRepository = recipeRepository;
    }

    public List<recipe> getAllRecipes()
    {
        try{
            return recipeRepository.findAll();
        }catch(Exception e){
            throw new RequestException("Couldn't find all recipes");
        }

    }

    public List<recipe> getRecipesByCategoryId(int categoryid)
    {
        try{
            return recipeRepository.findByCategoryid(categoryid);
        }catch(Exception e){
            throw new RequestException("Couldn't find products with categoryId");
        }

    }

    public recipe createRecipe(recipe recipe)
    {
        try{
            return recipeRepository.save(recipe);
        }catch(Exception e){
            throw new RequestException("Couldn't create recipe");
        }

    }

    public int getRecipeIdFromTitle(String title)
    {
        try{
            return recipeRepository.getRecipeIdFromTitle(title);
        }catch(Exception e){
            throw new RequestException("Couldn't find recipe with title");
        }

    }

    public recipe findById(int id)
    {
        try{
            return recipeRepository.findById(id);
        }catch(Exception e){
            throw new RequestException("Couldn't find the recipe by id");
        }

    }

    public String deleteRecipeById(int id)
    {
        try{
            recipeRepository.deleteById(id);
            return "recipe with id has been deleted = " + id;
        }catch(Exception e){
            throw new RequestException("Couldn't delete recipe by id");
        }

    }

    public recipe updateRecipe(recipe recipe)
    {
        try{
            recipe existingRecipe = recipeRepository.findById(recipe.getId());
            existingRecipe.setTitle(recipe.getTitle());
            existingRecipe.setDescription(recipe.getDescription());
            return recipeRepository.save(existingRecipe);
        }catch(Exception e){
            throw new RequestException("Couldn't Update Recipe");
        }

    }
}
