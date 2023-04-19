package com.franconeta.ferreteria.service;

import com.franconeta.ferreteria.model.Product;

import java.util.List;

public interface IProductService {
     Product createProduct(Product p);
     Product updateProduct(Product p);
     List<Product> findAllProducts();
     Product findProductById(Long id);
     void deleteProductById(Long id);
}
