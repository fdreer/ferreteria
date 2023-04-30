package com.franconeta.ferreteria.service;

import com.franconeta.ferreteria.dto.ProductDTO;
import com.franconeta.ferreteria.model.Product;

import java.util.List;

public interface IProductService {
     ProductDTO createProduct(Product p);
     ProductDTO updateProduct(Product p);
     List<ProductDTO> findAllProducts();
     ProductDTO findProductById(Long id);
     Product findProductModelById(Long id);
     void deleteProductById(Long id);
}
