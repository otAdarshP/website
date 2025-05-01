package com.Ecommerce.website.service.CategoryService;

import com.Ecommerce.website.Model.Category;
import com.Ecommerce.website.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

//    private List<Category> categories = new ArrayList<>();
    @Autowired
    private CategoryRepository categoryRepository;
    private Long nextId = 1L;

    // Initially it is empty, but as called by the Controller, it creates categories and then shows those categories as called by the Controller.

    @Override
    public void createCategory(Category category) {
//        category.setCategoryId(nextId++); // automatically providing id to the category
        categoryRepository.save(category);

    }

    @Override
    public ArrayList<Category> allcategories() {

        return (ArrayList<Category>) categoryRepository.findAll();
    }

    @Override
    public String deleteCategory(Long categoryId) {
        List<Category> categories = categoryRepository.findAll();
        Category category = categories.stream() // list is converted into stream
//                for category, check if the categoryId matches the category given in the requirement.
                .filter(c-> c.getCategoryId().equals(categoryId)) // filter is applied on the stream
                .findFirst().orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "categoryId not found!")); // when we get the first match, we take it.

        categories.remove(category); // for remove method to function / working, we need category objects.
        return "category with categoryId: " + categoryId + " deleted successfully!";
    }


    @Override
    public Category updateCategory(Category category, Long categoryId) {
        Optional<Category> savedCategoryOptional = categoryRepository.findById(categoryId);
        Category savedCategory = savedCategoryOptional
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found"));
        Category.setCategoryId(category.getCategoryId());
        savedCategory = categoryRepository.save(category);
        return savedCategory;
    }
}
