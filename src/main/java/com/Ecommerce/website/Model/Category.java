package com.Ecommerce.website.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity (name = "Categories")
public class Category {
    @Id
    private Long categoryId; // defining the features of the category
    private String categoryName; // defining the features of the category

    public Category(Long categoryId, String categoryName){ // creating new categories through this constructor class
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    // let us set new categories everytime and also check what is the category created.
    public void setCategoryId(Long categoryId){
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
