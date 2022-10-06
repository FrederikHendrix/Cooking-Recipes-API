package com.example.cookinrecipesapi.service;

import com.example.cookinrecipesapi.entity.user;
import com.example.cookinrecipesapi.repository.userRepository;
import com.example.cookinrecipesapi.repository.userRepositoryCustom;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService {
    private final userRepository userRepository;

    public userService(com.example.cookinrecipesapi.repository.userRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<user> getUser(){
        return userRepository.findAll();
    }

    public user createUser(user user)
    {
        return userRepository.save(user);
    }

    public user getUserById(int id){
        return userRepository.findById(id).orElse(null);
    }

}
