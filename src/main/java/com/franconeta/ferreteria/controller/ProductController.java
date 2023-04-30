package com.franconeta.ferreteria.controller;

import com.franconeta.ferreteria.dto.ProductDTO;
import com.franconeta.ferreteria.model.Product;
import com.franconeta.ferreteria.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
     @Autowired
     private IProductService productoService;

     @PostMapping
     public ResponseEntity<ProductDTO> createProduct(@RequestBody Product p) {
          ProductDTO product = productoService.createProduct(p);
          return new ResponseEntity<>(product, HttpStatus.CREATED);
     }

     @GetMapping("/{id}")
     public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
          ProductDTO product = productoService.findProductById(id);
          return new ResponseEntity<>(product, HttpStatus.OK);
     }

     @GetMapping
     public ResponseEntity<List<ProductDTO>> getAllProducts() {
          List<ProductDTO> productList = productoService.findAllProducts();
          return new ResponseEntity<>(productList, HttpStatus.OK);
     }

     @PutMapping
     public ResponseEntity<ProductDTO> updateProduct(@RequestBody Product p) {
          ProductDTO product = productoService.updateProduct(p);
          return new ResponseEntity<>(product, HttpStatus.OK);
     }

     @DeleteMapping("/{id}")
     public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
          productoService.deleteProductById(id);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }
}
