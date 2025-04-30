package com.Ecommerce.website.service.CategoryService;

import com.Ecommerce.website.Model.Category;

import java.util.ArrayList;
import java.util.List;

public interface CategoryService {

    // defines the actions to be performed by the implementation layer.
    void createCategory (Category category);
    ArrayList<Category> allcategories();


    String deleteCategory(Long cateogryId);

    Category updateCategory(Category updatedCategory, Long categoryId);

}
