package com.example.cookinrecipesapi.repository;

import com.example.cookinrecipesapi.entity.ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ingredientRepository extends JpaRepository<ingredient, Integer> {
    List<ingredient> findByRecipeid(int recipeid);

    void deleteByRecipeid(int recipeid);


}
