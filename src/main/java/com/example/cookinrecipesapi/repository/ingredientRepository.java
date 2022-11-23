package com.example.cookinrecipesapi.repository;

import com.example.cookinrecipesapi.entity.ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ingredientRepository extends JpaRepository<ingredient, Integer> {
    List<ingredient> findByRecipeid(int recipeid);
}
