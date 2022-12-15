package com.example.cookinrecipesapi.controller;

import com.example.cookinrecipesapi.entity.recipe;
import com.example.cookinrecipesapi.exception.RequestException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.example.cookinrecipesapi.service.recipeService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(recipeController.class)
class recipeControllerTest {

    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private recipeService recipeService;

    @Test
    void ShouldGiveAnOKStatusWhenPerformingGetAllRecipes() throws Exception {

        List<recipe> recipes = new ArrayList<>();

        when(recipeService.getAllRecipes())
                .thenReturn(recipes);
        mockMvc.perform(get("/api/get/recipes/"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void ShouldGiveOKStatusWhenCreateRecipe() throws Exception {

        mockMvc.perform(post("/api/post/recipe/")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(
                                new recipe(1,"PizzaMargarita", "Step 2: Cook Pizza", 1, 0, 1, new Date())))
                ).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void ShouldGiveOKStatusWhenUpdateRecipe() throws Exception {
        mockMvc.perform(put("/api/recipe/update")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(
                        new recipe(1,"PizzaMargarita", "Step 2: Cook Pizza", 1, 0, 1, new Date())))
                ).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void ShouldThrowExceptionWhenGetAllRecipes() throws Exception {
        when(recipeService.getAllRecipes()).thenThrow(new RequestException("Couldn't find all recipes"));

        Assertions.assertThatThrownBy(
                () -> mockMvc.perform(get("/api/get/recipes/").contentType(MediaType.APPLICATION_JSON)))
                .hasCauseInstanceOf(RequestException.class).hasMessageContaining("Couldn't find all recipes");
    }


    @Test
    void ShouldThrowExceptionWhenTryingToCreateNewRecipe() throws Exception {
        when(recipeService.createRecipe(new recipe(1,"PizzaMargarita", "Step 2: Cook Pizza", 1, 0, 1, new Date()))).thenThrow(new RequestException("Couldn't create recipe"));

        mockMvc.perform(post("/api/post/recipe/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


}