package com.example.cookinrecipesapi.repository;

import com.example.cookinrecipesapi.entity.category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface categoryRepository extends JpaRepository<category, Integer>{
}
