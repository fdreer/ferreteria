package com.franconeta.ferreteria.service.impl;

import com.franconeta.ferreteria.model.Category;
import com.franconeta.ferreteria.repository.CategoryRepository;
import com.franconeta.ferreteria.service.ICategoryService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService {

     @Autowired
     private CategoryRepository categoryRepository;

     @Override
     public Category createCategory(Category c) {
          if (categoryRepository.existsByName(c.getName().toUpperCase())) {     // desde el front se crean las categorias con MAYUSCULAS
               throw new EntityExistsException("La categoria " + c.getName() + " ya existe");
          }
          return categoryRepository.save(c);
     }

     @Override
     public Category updateCategory(Category c) {
          return createCategory(c);
     }

     @Override
     public List<Category> findAllCategories() {
          return categoryRepository.findAll();
     }

     @Override
     public Category findCategoryById(Long id) {
          Optional<Category> categoryOpt = categoryRepository.findById(id);

          if (categoryOpt.isPresent()) return categoryOpt.get();
          throw new EntityNotFoundException("La categoria con id " + id + " no existe");
     }

     @Override
     public void deleteCategoryById(Long id) {
          findCategoryById(id);
          categoryRepository.deleteById(id);
     }
}
