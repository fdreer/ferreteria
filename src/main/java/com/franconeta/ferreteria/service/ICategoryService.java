package com.franconeta.ferreteria.service;

import com.franconeta.ferreteria.model.Category;

import java.util.List;

public interface ICategoryService {
     Category createCategory(Category c);
     Category updateCategory(Category c);
     List<Category> findAllCategories();
     Category findCategoryById(Long id);
     void deleteCategoryById(Long id);

}
