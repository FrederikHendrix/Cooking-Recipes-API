package com.example.cookinrecipesapi.integration;

import com.example.cookinrecipesapi.entity.recipe;
import com.example.cookinrecipesapi.service.recipeService;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest
public class recipeIntegrationTest {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private recipeService recipeService;

    @Test
    void getAllRecipes() throws Exception {

        List<recipe> recipes = new ArrayList<>();

        when(recipeService.getAllRecipes())
                .thenReturn(recipes);
        mockMvc.perform(get("/api/get/recipes/"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void createRecipe() throws Exception {

        mockMvc.perform(post("/api/post/recipe/")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(
                        new recipe(1,"PizzaMargarita", "Step 2: Cook Pizza", 1, 0, 1, new Date())))
        ).andExpect(status().isOk());
    }
}
