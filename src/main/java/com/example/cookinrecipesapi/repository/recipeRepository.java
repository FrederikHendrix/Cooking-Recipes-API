package com.example.cookinrecipesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cookinrecipesapi.entity.recipe;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface recipeRepository extends JpaRepository<recipe,Integer> {
    @Query(value = "SELECT id FROM recipe WHERE title = ?1", nativeQuery = true)
    int getRecipeIdFromTitle(String title);

    List<recipe> findByCategoryid(int categoryid);
}
