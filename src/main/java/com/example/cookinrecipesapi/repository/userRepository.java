package com.example.cookinrecipesapi.repository;

import com.example.cookinrecipesapi.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<user,Integer> {
}
