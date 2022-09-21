package com.example.cookinrecipesapi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private int categoryid;
    private int totalrating;
    private int userid;
    private Date createdon;

    public recipe(int id, String title, String description, int categoryid, int totalrating, int userid, Date createdon) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.categoryid = categoryid;
        this.totalrating = totalrating;
        this.userid = userid;
        this.createdon = createdon;
    }

    public recipe()
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public int getTotalrating() {
        return totalrating;
    }

    public void setTotalrating(int totalrating) {
        this.totalrating = totalrating;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Date getCreatedon() {
        return createdon;
    }

    public void setCreatedon(Date createdon) {
        this.createdon = createdon;
    }
}
