package com.franconeta.ferreteria.service.impl;

import com.franconeta.ferreteria.repository.CategoryRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class CategoryServiceImplTest {

     @Mock
     private CategoryRepository categoryRepository;
     private AutoCloseable autoCloseable;
     private CategoryServiceImpl categoryService;

     @BeforeEach
     void setUp() {
          autoCloseable = MockitoAnnotations.openMocks(this);
          categoryService = new CategoryServiceImpl(categoryRepository);
     }

     @AfterEach
     void tearDown() throws Exception {
          autoCloseable.close();
     }

     @Test
     @Disabled
     void createCategory() {
     }

     @Test
     @Disabled
     void updateCategory() {
     }

     @Test
     @Disabled
     void findAllCategories() {
     }

     @Test
     @Disabled
     void findCategoryById() {
     }

     @Test
     @Disabled
     void findCategoryModelById() {
     }

     @Test
     @Disabled
     void deleteCategoryById() {
     }
}