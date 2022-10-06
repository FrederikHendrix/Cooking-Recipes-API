package com.example.cookinrecipesapi.service;

import com.example.cookinrecipesapi.entity.user;
import com.example.cookinrecipesapi.repository.userRepositoryCustom;
import org.springframework.stereotype.Service;

@Service
public class userServiceCustom {
    private final userRepositoryCustom userRepositoryCustom;

    public userServiceCustom(com.example.cookinrecipesapi.repository.userRepositoryCustom userRepositoryCustom) {
        this.userRepositoryCustom = userRepositoryCustom;
    }

    public user getUserByAuthid(String authid)
    {
        return userRepositoryCustom.getUserByAuthid(authid);
    }

}
