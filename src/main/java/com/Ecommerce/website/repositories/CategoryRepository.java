package com.Ecommerce.website.repositories;

import com.Ecommerce.website.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
