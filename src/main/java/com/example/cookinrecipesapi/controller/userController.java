package com.example.cookinrecipesapi.controller;

import com.example.cookinrecipesapi.entity.user;
import com.example.cookinrecipesapi.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class userController {

    @Autowired
    private userService service;

    @GetMapping(value ="user")
    public List<user> findAllUsers(){
        return service.getUser();
    }

}
