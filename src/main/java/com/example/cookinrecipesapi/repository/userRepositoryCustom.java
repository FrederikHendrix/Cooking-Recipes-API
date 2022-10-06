package com.example.cookinrecipesapi.repository;

import com.example.cookinrecipesapi.entity.user;

public interface userRepositoryCustom {
    user getUserByAuthid(String authid);
}
