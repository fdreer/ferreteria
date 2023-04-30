package com.franconeta.ferreteria.controller;

import com.franconeta.ferreteria.dto.PurchaseProductDTO;
import com.franconeta.ferreteria.model.PurchaseProduct;
import com.franconeta.ferreteria.service.IPurchaseProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchase-product")
public class PurchaseProductController {
     @Autowired
     private IPurchaseProductService purchaseProductService;

     @PostMapping
     public ResponseEntity<PurchaseProductDTO> createPurchaseProduct(@RequestBody PurchaseProduct p) {
          PurchaseProductDTO purchaseProduct = purchaseProductService.createPurchaseProduct(p);
          return new ResponseEntity<>(purchaseProduct, HttpStatus.CREATED);
     }

     @GetMapping("/{id}")
     public ResponseEntity<PurchaseProductDTO> getPurchaseProduct(@PathVariable Long id) {
          PurchaseProductDTO purchaseProduct = purchaseProductService.findPurchaseProductById(id);
          return new ResponseEntity<>(purchaseProduct, HttpStatus.OK);
     }

     @GetMapping
     public ResponseEntity<List<PurchaseProductDTO>> getAllPurchaseProducts() {
          List<PurchaseProductDTO> purchaseProductList = purchaseProductService.findAllPurchaseProducts();
          return new ResponseEntity<>(purchaseProductList, HttpStatus.OK);
     }

     @PutMapping
     public ResponseEntity<PurchaseProductDTO> updatePurchaseProduct(@RequestBody PurchaseProduct p) {
          PurchaseProductDTO purchaseProduct = purchaseProductService.updatePurchaseProduct(p);
          return new ResponseEntity<>(purchaseProduct, HttpStatus.OK);
     }

     @DeleteMapping("/{id}")
     public ResponseEntity<?> deletePurchaseProduct(@PathVariable Long id) {
          purchaseProductService.deletePurchaseProductById(id);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }

}
