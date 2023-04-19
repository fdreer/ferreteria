package com.franconeta.ferreteria.controller;

import com.franconeta.ferreteria.model.Category;
import com.franconeta.ferreteria.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

     @Autowired
     private ICategoryService categoryService;

     @PostMapping
     public ResponseEntity<Category> createCategory(@RequestBody Category c) {
          Category category = categoryService.createCategory(c);
          return new ResponseEntity<>(category, HttpStatus.CREATED);
     }

     @GetMapping("/{id}")
     public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
          Category category = categoryService.findCategoryById(id);
          return new ResponseEntity<>(category, HttpStatus.OK);
     }

     @GetMapping
     public ResponseEntity<List<Category>> getAllCategories() {
          List<Category> categoryList = categoryService.findAllCategories();
          return new ResponseEntity<>(categoryList, HttpStatus.OK);
     }

     @PutMapping
     public ResponseEntity<Category> updateCategory(@RequestBody Category c) {
          Category category = categoryService.updateCategory(c);
          return new ResponseEntity<>(category, HttpStatus.OK);
     }

     @DeleteMapping("/{id}")
     public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
          categoryService.deleteCategoryById(id);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }
}
