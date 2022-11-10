package com.example.cookinrecipesapi.repository;

import com.example.cookinrecipesapi.entity.recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Component
public class recipeRepositoryImpl implements recipeRepositoryCustom{

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unused")
    public int getRecipeIdFromTitle(String title) {
        String hql = "SELECT e FROM recipe e WHERE e.title= :title";
        TypedQuery<recipe> query = entityManager.createQuery(hql, recipe.class);
        query.setParameter("title", title);
        recipe recipe = query.getSingleResult();
        return recipe.getId();
    }
}