package com.franconeta.ferreteria.service.impl;

import com.franconeta.ferreteria.dto.PurchaseProductDTO;
import com.franconeta.ferreteria.model.Product;
import com.franconeta.ferreteria.model.PurchaseProduct;
import com.franconeta.ferreteria.repository.PurchaseProductRepository;
import com.franconeta.ferreteria.service.IProductService;
import com.franconeta.ferreteria.service.IPurchaseProductService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseProductServiceImpl implements IPurchaseProductService {

     @Autowired
     private PurchaseProductRepository purchaseProductRepository;
     @Autowired
     private IProductService productService;

     private PurchaseProductDTO convertToDTO(PurchaseProduct purchaseProduct) {
          return new PurchaseProductDTO(
                  purchaseProduct.getId(),
                  purchaseProduct.getProduct().getName(),
                  purchaseProduct.getPrice(),
                  purchaseProduct.getUnits(),
                  purchaseProduct.getPrice() * purchaseProduct.getUnits(),
                  purchaseProduct.getReceived()
          );
     }

     @Override
     public PurchaseProductDTO createPurchaseProduct(PurchaseProduct purchaseProduct) {
          Product product = productService.findProductModelById(purchaseProduct.getProduct().getId());
          purchaseProduct.setProduct(product);
          PurchaseProduct productSave = purchaseProductRepository.save(purchaseProduct);
          return convertToDTO(productSave);
     }

     @Override
     public PurchaseProductDTO updatePurchaseProduct(PurchaseProduct p) {
          return createPurchaseProduct(p);
     }

     @Override
     public List<PurchaseProductDTO> findAllPurchaseProducts() {
          return purchaseProductRepository.findAll()
                  .stream().map(purchaseProduct -> convertToDTO(purchaseProduct))
                  .collect(Collectors.toList());
     }

     @Override
     public PurchaseProductDTO findPurchaseProductById(Long id) {
          return purchaseProductRepository.findById(id)
                  .map(purchaseProduct -> convertToDTO(purchaseProduct))
                  .orElseThrow(() -> new EntityNotFoundException("La orden de compra con el id " + id + " no existe"));
     }

     @Override
     public PurchaseProduct findPurchaseProductModelById(Long id) {
          return purchaseProductRepository.findById(id)
                  .orElseThrow(() -> new EntityNotFoundException("La orden de compra con el id " + id + " no existe"));
     }

     @Override
     public void deletePurchaseProductById(Long id) {
          purchaseProductRepository.deleteById(id);
     }
}
