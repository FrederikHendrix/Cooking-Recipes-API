package com.example.cookinrecipesapi.repository;

import com.example.cookinrecipesapi.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface userRepository extends JpaRepository<user,Integer> {

    user findByAuthid(String authid);

    @Query(value = "SELECT id FROM user WHERE authid = ?1", nativeQuery = true)
    int getUserIdByAuthid(String authid);
}
