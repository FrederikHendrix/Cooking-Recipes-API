package com.example.cookinrecipesapi.repository;

import com.example.cookinrecipesapi.entity.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Component
public class userRepositoryImpl implements userRepositoryCustom{

   @PersistenceContext
   private EntityManager entityManager;

    @SuppressWarnings("unused")
    public user getUserByAuthid(String authid) {
        String hql = "SELECT e FROM user e WHERE e.authid= :authid";
        TypedQuery<user> query = entityManager.createQuery(hql, user.class);
        query.setParameter("authid", authid);
        return query.getSingleResult();
    }

    @SuppressWarnings("unused")
    public int getUserIdByAuthid(String authid) {
        String hql = "SELECT e FROM user e WHERE e.authid= :authid";
        TypedQuery<user> query = entityManager.createQuery(hql, user.class);
        query.setParameter("authid", authid);
        user user = query.getSingleResult();
        return user.getId();
    }
}
