package com.Ecommerce.website.Controller;

import com.Ecommerce.website.Model.Category;
import com.Ecommerce.website.service.CategoryService.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
//@RequestMapping("/api")   the common part of all the mappings are designated and shown at the first place.
@RestController
public class CategoryController {

//    connects the controller with the Category serivce to call the categories and create the new categories directly.
    @Autowired
    private CategoryService categoryService;

//@RequestMapping(value = "/api/public/categories", method = RequestMethod.GET)  same as below, just that we don't have to specifiy individually every class.
    @GetMapping("/api/public/categories")
//    public ResponseEntity<ArrayList<Category>> allcategories(){
    public ArrayList<Category> allcategories(){
        return categoryService.allcategories(); // returns all the existing categories
//        return new ResponseEntity<>(categories, HttpStatus.OK);

    }

    @PostMapping ("/api/public/categories")
//    public ResponseEntity<String> createCategory (@RequestBody List<Category> categories){
    public String createCategory (@RequestBody List<Category> categories){ // creates a new category (name & id) through the variable category
        categories.forEach(categoryService::createCategory);
        return "Category created successfully.";
//        return new ResponseEntity<> ("Category created successfully", HttpStatus.CREATED);
    }

    @DeleteMapping ("/api/admin/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory (@PathVariable Long categoryId){
        try {
            String status = categoryService.deleteCategory(categoryId);
            return new ResponseEntity<>(status, HttpStatus.OK);
        }
        catch (ResponseStatusException exception){
            return new ResponseEntity<>(exception.getReason(), exception.getStatusCode());
        }
    }

    @PutMapping ("/api/public/categories/{categoryId}")
    public ResponseEntity<String>  updateCategory (@RequestBody Category category, @PathVariable Long categoryId){
        try{
            Category savedCategory = categoryService.updateCategory (category, categoryId);
            return new ResponseEntity<> ("Category with category ID" + categoryId + " updated successfully", HttpStatus.OK);
        }
        catch (ResponseStatusException exception){
            return new ResponseEntity<>(exception.getReason(), exception.getStatusCode());
        }
    }
}
