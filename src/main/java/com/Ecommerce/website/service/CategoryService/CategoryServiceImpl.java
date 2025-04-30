package com.Ecommerce.website.service.CategoryService;

import com.Ecommerce.website.Model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    private List<Category> categories = new ArrayList<>();
    private Long nextId = 1L;

    // Initially it is empty, but as called by the Controller, it creates categories and then shows those categories as called by the Controller.

    @Override
    public void createCategory(Category category) {
        category.setCategoryId(nextId++); // automatically providing id to the category
        categories.add(category);

    }

    @Override
    public ArrayList<Category> allcategories() {
        return (ArrayList<Category>) categories;
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categories.stream() // list is converted into stream
//                for category, check if the categoryId matches the category given in the requirement.
                .filter(c-> c.getCategoryId().equals(categoryId)) // filter is applied on the stream
                .findFirst().orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "categoryId not found!")); // when we get the first match, we take it.

        categories.remove(category); // for remove method to function / working, we need category objects.
        return "category with categoryId: " + categoryId + " deleted successfully!";
    }


    @Override
    public Category updateCategory(Category category, Long categoryId) {
        Optional<Category> optionalCategory = categories.stream()
                .filter(c -> c.getCategoryId().equals(categoryId))
                .findFirst();

        if (optionalCategory.isPresent()){
            Category existingCategory = optionalCategory.get();
            existingCategory.setCategoryName(category.getCategoryName());
            return existingCategory;
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found.");
        }
    }
}
