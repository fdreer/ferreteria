package com.franconeta.ferreteria.repository;

import com.franconeta.ferreteria.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Product, Long> {
     Boolean existsByName(String name);
}