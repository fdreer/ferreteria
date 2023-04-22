package com.franconeta.ferreteria.service.impl;

import com.franconeta.ferreteria.model.Category;
import com.franconeta.ferreteria.model.Product;
import com.franconeta.ferreteria.repository.ProductRepository;
import com.franconeta.ferreteria.service.ICategoryService;
import com.franconeta.ferreteria.service.IProductService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

     @Autowired
     private ProductRepository productRepository;
     @Autowired
     private ICategoryService categoryService;

     public void productExistsByName (String name) {
          if (productRepository.existsByName(name.toUpperCase())) {
               throw new EntityExistsException("El producto " + name + " ya existe");
          }
     }

     @Override
     public Product createProduct(Product p) {
          productExistsByName(p.getName());
          Category categoryToAssign = categoryService.findCategoryById(p.getCategory().getId()); // --> puede saltar una EntityNotFoundException
          p.setCategory(categoryToAssign);
          return productRepository.save(p);
     }

     @Override
     public Product updateProduct(Product p) {
          return createProduct(p);
     }

     @Override
     public List<Product> findAllProducts() {
          return productRepository.findAll();
     }

     @Override
     public Product findProductById(Long id) {
          Optional<Product> productOpt = productRepository.findById(id);
          if (productOpt.isPresent()) {
               return productOpt.get();
          }
          throw new EntityNotFoundException("El producto con el id " + id + " no existe");
     }

     @Override
     public void deleteProductById(Long id) {
          findProductById(id);
          productRepository.deleteById(id);
     }
}
