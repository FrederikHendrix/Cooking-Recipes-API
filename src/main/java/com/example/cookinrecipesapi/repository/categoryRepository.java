package com.example.cookinrecipesapi.repository;

import com.example.cookinrecipesapi.entity.category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface categoryRepository extends JpaRepository<category, Integer>{
}
