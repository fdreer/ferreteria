package com.franconeta.ferreteria.repository;

import com.franconeta.ferreteria.model.Category;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CategoryRepositoryTest {

     @Autowired
     private CategoryRepository categoryRepository;

     @AfterEach     // para cada test tenemos un clean state
     void tearDown() {
          categoryRepository.deleteAll();
     }

     @Test
     public void existsByName() {
          String categoryName = "pinturas";
          Category category = new Category(categoryName);
          categoryRepository.save(category);

          Boolean expectedResult = categoryRepository.existsByName(categoryName);

          assertThat(expectedResult).isTrue();
     }

     @Test
     public void noExistsByName() {
          String categoryName = "pinturas";
          Boolean expectedResult = categoryRepository.existsByName(categoryName);

          assertThat(expectedResult).isFalse();
     }
}