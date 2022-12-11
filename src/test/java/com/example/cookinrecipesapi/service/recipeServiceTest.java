package com.example.cookinrecipesapi.service;

import com.example.cookinrecipesapi.entity.recipe;
import com.example.cookinrecipesapi.repository.recipeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class recipeServiceTest {

    @Mock
    private recipeRepository recipeRepository;
    private AutoCloseable autoCloseable;
    private recipeService underTest;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new recipeService(recipeRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllRecipes() {
        // when
        underTest.getAllRecipes();

        // then
        verify(recipeRepository).findAll();

    }

    @Test
    void canGetRecipesByCategoryId() {
        // when
        int categoryId = 1;
        underTest.getRecipesByCategoryId(categoryId);

        // then
        verify(recipeRepository).findByCategoryid(categoryId);

    }

    @Test
    void canCreateRecipe() {
        // arrange
        recipe recipe = new recipe(1, "Pizza", "Step 1", 1, 1, 1, new Date());

        // act
        underTest.createRecipe(recipe);

        // assert
        verify(recipeRepository).save(recipe);

        ArgumentCaptor<recipe> recipeArgumentCaptor = ArgumentCaptor.forClass(recipe.class);

        verify(recipeRepository).save(recipeArgumentCaptor.capture());

        recipe capturedRecipe = recipeArgumentCaptor.getValue();

        assertThat(capturedRecipe).isEqualTo(recipe);


    }

    @Test
    void canGetRecipeIdFromTitle() {
        // when
        String title = "Pizza";
        underTest.getRecipeIdFromTitle(title);

        // then
        verify(recipeRepository).getRecipeIdFromTitle(title);

    }

    @Test
    void canFindRecipeById() {
        // when
        int recipeId = 1;
        underTest.findById(recipeId);

        // then
        verify(recipeRepository).findById(recipeId);

    }

    @Test
    void canDeleteById() {
        //when
        underTest.deleteRecipeById(1);

        //then
        verify(recipeRepository).deleteById(1);

    }

}