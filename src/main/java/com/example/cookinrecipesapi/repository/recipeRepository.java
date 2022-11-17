package com.example.cookinrecipesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cookinrecipesapi.entity.recipe;
import org.springframework.data.jpa.repository.Query;

public interface recipeRepository extends JpaRepository<recipe,Integer>, recipeRepositoryCustom {

}
