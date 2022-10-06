package com.example.cookinrecipesapi.controller;

import com.example.cookinrecipesapi.entity.user;
import com.example.cookinrecipesapi.service.userService;
import com.example.cookinrecipesapi.service.userServiceCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class userControllerCustom {

   @Autowired
   private userServiceCustom userServiceCustom;

    @GetMapping(value = "/get/usercustom/{authid}")
   public user getUserByAuthid(@PathVariable String authid){return userServiceCustom.getUserByAuthid(authid);}
}

