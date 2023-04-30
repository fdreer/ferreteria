package com.franconeta.ferreteria.service.impl;

import com.franconeta.ferreteria.dto.ProductDTO;
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
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService {

     @Autowired
     private ProductRepository productRepository;
     @Autowired
     private ICategoryService categoryService;

     private void productExistsByName (String name) {
          if (productRepository.existsByName(name.toUpperCase())) {
               throw new EntityExistsException("El producto " + name + " ya existe");
          }
     }
     private ProductDTO convertToDTO(Product product) {
          return new ProductDTO(
                  product.getId(),
                  product.getName(),
                  product.getCategory().getName()
          );
     }

     @Override
     public ProductDTO createProduct(Product p) {
          productExistsByName(p.getName());  // --> puede lanzar una EntityExistsException
          Category categoryToAssign = categoryService.findCategoryModelById(p.getCategory().getId());
          p.setCategory(categoryToAssign);
          Product productSave = productRepository.save(p);
          return convertToDTO(productSave);
     }

     @Override
     public ProductDTO updateProduct(Product p) {
          return createProduct(p);
     }

     @Override
     public List<ProductDTO> findAllProducts() {
     return productRepository.findAll()
             .stream().map(product ->  convertToDTO(product))
             .collect(Collectors.toList());
     }

     @Override
     public ProductDTO findProductById(Long id) {
          return productRepository.findById(id)
                  .map(product ->  convertToDTO(product))
                  .orElseThrow(() -> new EntityNotFoundException("El producto con el id " + id + " no existe"));
     }

     @Override
     public Product findProductModelById(Long id) {
          return productRepository.findById(id)
                  .orElseThrow(() -> new EntityNotFoundException("El producto con el id " + id + " no existe"));
     }

     @Override
     public void deleteProductById(Long id) {
          findProductById(id);
          productRepository.deleteById(id);
     }
}
