package com.example.cookinrecipesapi.repository;

import com.example.cookinrecipesapi.entity.user;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class userRepositoryTest {

    @Autowired
    private userRepository underTest;

    @Test
    void functionShouldFindUserByAuthid() {
        // arrange
        String authId = "auth0123";
        user userAuth = new user(1,authId, 0, new Date());
        underTest.save(userAuth);

        // act
        user user = underTest.findByAuthid(authId);

        // assert
        assertThat(user.getAuthid()).isEqualTo(authId);

    }

    @Test
    void functionShouldNotFindUserByAuthid() {
        // arrange
        String authId = "auth0123";
        String authIdFake = "auth012345";
        user userAuth = new user(1,authId, 0, new Date());
        underTest.save(userAuth);

        // act
        user user = underTest.findByAuthid(authId);

        // assert
        assertThat(user.getAuthid()).isNotEqualTo(authIdFake);

    }

    @Test
    void functionShouldGetUserIdByAuthid() {
        // arrange
        String authId = "auth01234";
        user userAuth = new user(1,authId, 0, new Date());
        underTest.save(userAuth);
        List<user> users = underTest.findAll();
        int userIdReference = 0;

        // act
        int userId = underTest.getUserIdByAuthid(authId);

        for(int i = 0; i < users.size(); i++)
        {
            if(users.get(i).getAuthid().equals(authId))
            {
                userIdReference = users.get(i).getId();
            }
        }

        // assert
        assertThat(userId).isEqualTo(userIdReference);


    }

    @Test
    void functionShouldNotGetUserIdByAuthid() {
        // arrange
        String authId = "auth01234";
        user userAuth = new user(1,authId, 0, new Date());
        underTest.save(userAuth);
        List<user> users = underTest.findAll();
        int userIdReference = 0;
        int userIdFake = 6;

        // act
        int userId = underTest.getUserIdByAuthid(authId);

        for(int i = 0; i < users.size(); i++)
        {
            if(users.get(i).getAuthid().equals(authId))
            {
                userIdReference = users.get(i).getId();
            }
        }

        // assert
        assertThat(userId).isNotEqualTo(userIdFake);



    }
}