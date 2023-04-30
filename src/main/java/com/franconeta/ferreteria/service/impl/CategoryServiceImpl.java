package com.franconeta.ferreteria.service.impl;

import com.franconeta.ferreteria.dto.CategoryDTO;
import com.franconeta.ferreteria.model.Category;
import com.franconeta.ferreteria.repository.CategoryRepository;
import com.franconeta.ferreteria.service.ICategoryService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements ICategoryService {

     @Autowired
     private CategoryRepository categoryRepository;

     private CategoryDTO convertToDTO(Category category) {
          return new CategoryDTO(
                  category.getId(),
                  category.getName()
          );
     }

     @Override
     public CategoryDTO createCategory(Category c) {
          if (categoryRepository.existsByName(c.getName())) {
               throw new EntityExistsException("La categoria " + c.getName() + " ya existe");
          }
          Category categorySave = categoryRepository.save(c);
          return convertToDTO(categorySave);
     }

     @Override
     public CategoryDTO updateCategory(Category c) {
          return createCategory(c);
     }

     @Override
     public List<CategoryDTO> findAllCategories() {
     return categoryRepository.findAll()
             .stream().map(c -> convertToDTO(c))
             .collect(Collectors.toList());
     }

     @Override
     public CategoryDTO findCategoryById(Long id) {
          return categoryRepository.findById(id)
                  .map(c -> convertToDTO(c))
                  .orElseThrow(() -> new EntityNotFoundException("La categoria con id " + id + " no existe"));
     }

     @Override
     public Category findCategoryModelById(Long id) {
          return categoryRepository.findById(id)
                  .orElseThrow(() -> new EntityNotFoundException("La categoria con id " + id + " no existe"));
     }

     @Override
     public void deleteCategoryById(Long id) {
          findCategoryById(id);
          categoryRepository.deleteById(id);
     }
}
