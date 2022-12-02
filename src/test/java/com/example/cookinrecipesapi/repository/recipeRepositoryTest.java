package com.example.cookinrecipesapi.repository;

import com.example.cookinrecipesapi.entity.recipe;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class recipeRepositoryTest {

    @Autowired
    private recipeRepository underTest;

    @Test
    void functionShouldGetRecipeIdFromRecipeTitle() {
        // arrange
        String recipeTitle = "PizzaMargarita";
        recipe recipe = new recipe(1,recipeTitle, "Step 1: Cook Pizza", 1, 0, 1, new Date());
        underTest.save(recipe);
        recipe recipeFindById;
        int recipeIdFromTitle;

        // act
        recipeIdFromTitle = underTest.getRecipeIdFromTitle(recipeTitle);
        recipeFindById = underTest.findById(recipeIdFromTitle);

        // assert
        assertThat(recipeIdFromTitle).isEqualTo(recipeFindById.getId());

    }

    @Test
    void functionShouldNotGetRecipeIdFromRecipeTitle() {
        // arrange
        int recipeId = 1;
        recipe recipe = new recipe(recipeId,"PizzaMargarit", "Step 1: Cook Pizza", 1, 0, 1, new Date());
        recipe recipe2 = new recipe(recipeId,"PizzaMargaritaaa", "Step 1: Cook Pizza", 1, 0, 1, new Date());
        underTest.save(recipe);
        underTest.save(recipe2);
        int index = 1;
        int recipeIdFromTitle;
        List<recipe> recipes = underTest.findAll();

        // act
        recipeIdFromTitle = underTest.getRecipeIdFromTitle(recipes.get(index).getTitle());

        // assert
        assertThat(recipeIdFromTitle).isNotEqualTo(recipeId);

    }

    @Test
    void functionShouldFindRecipesByCategoryId() {
        // arrange
        int categoryId = 1;
        List<recipe> recipesByCategory;

        // act
        recipesByCategory = underTest.findByCategoryid(categoryId);

        // assert
        for(int i = 0; i < recipesByCategory.size(); i++)
        {
            assertThat(recipesByCategory.get(i).getCategoryid()).isEqualTo(categoryId);
        }
    }

    @Test
    void functionShouldNotFindRecipesByCategoryId() {
        // arrange
        int categoryId = 2;
        int categoryIdWrong = 1;
        List<recipe> recipesByCategory;

        // act
        recipesByCategory = underTest.findByCategoryid(categoryId);

        // assert
        for(int i = 0; i < recipesByCategory.size(); i++)
        {
            assertThat(recipesByCategory.get(i).getCategoryid()).isNotEqualTo(categoryIdWrong);
        }
    }

    @Test
    void functionShouldFindRecipeById() {
        // arrange
        int recipeId = 1;
        recipe recipe = new recipe(recipeId,"PizzaMargarita", "Step 1: Cook Pizza", 1, 0, 1, new Date());
        recipe recipeCheck;
        underTest.save(recipe);
        List<recipe> recipes = underTest.findAll();

        // act
        recipeCheck = underTest.findById(recipeId);

        // assert
        assertThat(recipes.get(0)).isEqualTo(recipeCheck);
    }

    @Test
    void functionShouldNotFindRecipeById() {
        // arrange
        int recipeId = 1;
        recipe recipe = new recipe(recipeId,"PizzaMargarita", "Step 1: Cook Pizza", 1, 0, 1, new Date());
        recipe recipeCheck = new recipe(2,"PizzaMargaritaaaa", "Step 2: Cook Pizza", 1, 0, 1, new Date());;
        underTest.save(recipe);
        List<recipe> recipes = underTest.findAll();

        // act

        // assert
        assertThat(recipes.get(0)).isNotEqualTo(recipeCheck);
    }

}