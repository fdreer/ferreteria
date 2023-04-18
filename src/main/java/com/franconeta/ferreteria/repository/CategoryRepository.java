package com.franconeta.ferreteria.repository;

import com.franconeta.ferreteria.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
     Boolean existsByName(String name);
}