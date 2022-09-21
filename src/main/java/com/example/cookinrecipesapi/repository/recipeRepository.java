package com.example.cookinrecipesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cookinrecipesapi.entity.recipe;

public interface recipeRepository extends JpaRepository<recipe,Integer> {
}
