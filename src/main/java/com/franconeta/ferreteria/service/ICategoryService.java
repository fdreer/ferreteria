package com.franconeta.ferreteria.service;

import com.franconeta.ferreteria.dto.CategoryDTO;
import com.franconeta.ferreteria.model.Category;

import java.util.List;

public interface ICategoryService {
     CategoryDTO createCategory(Category c);
     CategoryDTO updateCategory(Category c);
     List<CategoryDTO> findAllCategories();
     CategoryDTO findCategoryById(Long id);
     Category findCategoryModelById(Long id);
     void deleteCategoryById(Long id);
}
