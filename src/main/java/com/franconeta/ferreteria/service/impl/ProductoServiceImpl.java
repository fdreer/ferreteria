package com.franconeta.ferreteria.service.impl;

import com.franconeta.ferreteria.model.Category;
import com.franconeta.ferreteria.model.Product;
import com.franconeta.ferreteria.repository.ProductoRepository;
import com.franconeta.ferreteria.service.ICategoryService;
import com.franconeta.ferreteria.service.IProductoService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements IProductoService {

     @Autowired
     private ProductoRepository productoRepository;
     @Autowired
     private ICategoryService categoryService;

     @Override
     public Product createProduct(Product p) {
          if (productoRepository.existsByName(p.getName().toUpperCase())) {
               throw new EntityExistsException("El producto " + p.getName() + " ya existe");
          }
          Category categoryToAssign = categoryService.findCategoryById(p.getCategory().getId()); // --> puede saltar una EntityNotFoundException
          p.setCategory(categoryToAssign);
          return productoRepository.save(p);
     }

     @Override
     public Product updateProduct(Product p) {
          return createProduct(p);
     }

     @Override
     public List<Product> findAllProducts() {
          return productoRepository.findAll();
     }

     @Override
     public Product findProductById(Long id) {
          Optional<Product> productOpt = productoRepository.findById(id);
          if (productOpt.isPresent()) {
               return productOpt.get();
          }
          throw new EntityNotFoundException("El producto con el id " + id + " no existe");
     }

     @Override
     public void deleteProductById(Long id) {
          findProductById(id);
          productoRepository.deleteById(id);
     }

//     public Product addProductToCategory(Product p) {
//          Product product = findProductById(p.getId());
//          Category category = categoryService.findCategoryById(p.getCategory().getId());
//     }
}
