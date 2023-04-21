package com.franconeta.ferreteria.service.impl;

import com.franconeta.ferreteria.model.Product;
import com.franconeta.ferreteria.model.PurchaseProduct;
import com.franconeta.ferreteria.repository.PurchaseProductRepository;
import com.franconeta.ferreteria.service.IProductService;
import com.franconeta.ferreteria.service.IPurchaseProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseProductServiceImpl implements IPurchaseProductService {

     @Autowired
     private PurchaseProductRepository purchaseProductRepository;
     @Autowired
     private IProductService productService;

     @Override
     public PurchaseProduct createPurchaseProduct(PurchaseProduct p) {
          Product product = productService.findProductById(p.getProduct().getId());
          p.setProduct(product);
          return purchaseProductRepository.save(p);
     }

     @Override
     public PurchaseProduct updatePurchaseProduct(PurchaseProduct p) {
          return createPurchaseProduct(p);
     }

     @Override
     public List<PurchaseProduct> findAllPurchaseProducts() {
          return purchaseProductRepository.findAll();
     }

     @Override
     public PurchaseProduct findPurchaseProductById(Long id) {
          Optional<PurchaseProduct> product = purchaseProductRepository.findById(id);
          return product.get();
     }

     @Override
     public void deletePurchaseProductById(Long id) {
          purchaseProductRepository.deleteById(id);
     }
}
