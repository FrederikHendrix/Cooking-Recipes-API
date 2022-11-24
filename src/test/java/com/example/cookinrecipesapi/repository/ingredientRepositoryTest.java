package com.example.cookinrecipesapi.repository;

import com.example.cookinrecipesapi.entity.ingredient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ingredientRepositoryTest {

    @Autowired
    private ingredientRepository underTest;

    @Test
    void functionShouldFindIngredientsByRecipeId() {
        // arrange
        int recipeId = 1;

        // act
        List<ingredient> ingredients = underTest.findByRecipeid(recipeId);

        // assert
        for(int i = 0; i < ingredients.size(); i++)
        {
            assertThat(ingredients.get(i).getRecipeid()).isEqualTo(recipeId);
        }

    }
}