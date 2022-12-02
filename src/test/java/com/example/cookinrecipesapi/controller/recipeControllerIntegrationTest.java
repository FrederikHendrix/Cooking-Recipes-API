package com.example.cookinrecipesapi.controller;

import com.example.cookinrecipesapi.entity.recipe;
import com.example.cookinrecipesapi.service.recipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {
        "classpath*:spring/applicationContext.xml",
        "classpath*:spring/applicationContext-jpa.xml",
        "classpath*:spring/applicationContext-security.xml" })
@WebAppConfiguration
class recipeControllerIntegrationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private recipeService recipeService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }


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