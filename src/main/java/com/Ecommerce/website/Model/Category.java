package com.Ecommerce.website.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity (name = "Categories")
public class Category {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long categoryId; // defining the features of the category
    private String categoryName; // defining the features of the category

    public Category(Long categoryId, String categoryName){ // creating new categories through this constructor class
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

//    any empty constructor is a good practice when using JPA
    public Category (){
    }

    // let us set new categories everytime and also check what is the category created.
    public static void setCategoryId(Long categoryId){
        this.categoryId = categoryId;
    }
    public Long getCategoryId(){
        return Long.valueOf(categoryId);
    }

    public void setCategoryName (String categoryName){
        this.categoryName = categoryName;
    }
    public String getCategoryName(){
        return categoryName;
    }







}
