package com.franconeta.ferreteria.controller;

import com.franconeta.ferreteria.model.Product;
import com.franconeta.ferreteria.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductoController {
     @Autowired
     private IProductoService productoService;

     @PostMapping
     public ResponseEntity<Product> createProduct(@RequestBody Product p) {
          Product product = productoService.createProduct(p);
          return new ResponseEntity<>(product, HttpStatus.CREATED);
     }

     @GetMapping("/{id}")
     public ResponseEntity<Product> getProductById(@PathVariable Long id) {
          Product product = productoService.findProductById(id);
          return new ResponseEntity<>(product, HttpStatus.OK);
     }

     @GetMapping
     public ResponseEntity<List<Product>> getAllProducts() {
          List<Product> productList = productoService.findAllProducts();
          return new ResponseEntity<>(productList, HttpStatus.OK);
     }

     @PutMapping
     public ResponseEntity<Product> updateProduct(@RequestBody Product p) {
          Product product = productoService.updateProduct(p);
          return new ResponseEntity<>(product, HttpStatus.OK);
     }

     @DeleteMapping("/{id}")
     public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
          productoService.deleteProductById(id);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }
}
