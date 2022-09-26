package com.example.cookinrecipesapi.repository;

import com.example.cookinrecipesapi.entity.ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ingredientRepository extends JpaRepository<ingredient, Integer> {
}
