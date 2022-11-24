package com.example.cookinrecipesapi.controller;

import com.example.cookinrecipesapi.entity.recipe;
import com.example.cookinrecipesapi.service.recipeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@DataJpaTest
class recipeIntegrationTest {

    @Autowired
    private recipeService recipeService;

    @Test
    void getAllRecipes() {

        List<recipe> recipes = new ArrayList<>();




    }

    @Test
    void createRecipe() {
    }

    @Test
    void getRecipeById() {
    }

    @Test
    void getRecipesByCategoryId() {
    }

    @Test
    void getRecipeIdFromTitle() {
    }
}