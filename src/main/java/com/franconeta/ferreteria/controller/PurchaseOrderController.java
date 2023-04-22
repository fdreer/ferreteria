package com.franconeta.ferreteria.controller;

import com.franconeta.ferreteria.model.PurchaseOrder;
import com.franconeta.ferreteria.service.IPurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchase-order")
public class PurchaseOrderController {
     @Autowired
     private IPurchaseOrderService purchaseOrderService;

     @PostMapping
     public ResponseEntity<PurchaseOrder> createPurchaseOrder(@RequestBody PurchaseOrder p) {
          PurchaseOrder purchaseOrder = purchaseOrderService.createPurchaseOrder(p);
          return new ResponseEntity<>(purchaseOrder, HttpStatus.CREATED);
     }

     @GetMapping("/{id}")
     public ResponseEntity<PurchaseOrder> getPurchaseOrder(@PathVariable Long id) {
          PurchaseOrder purchaseOrder = purchaseOrderService.findPurchaseOrderById(id);
          return new ResponseEntity<>(purchaseOrder, HttpStatus.OK);
     }

     @GetMapping
     public ResponseEntity<List<PurchaseOrder>> getAllPurchaseOrders() {
          List<PurchaseOrder> purchaseOrderList = purchaseOrderService.findAllPurchaseOrders();
          return new ResponseEntity<>(purchaseOrderList, HttpStatus.OK);
     }

     @PutMapping
     public ResponseEntity<PurchaseOrder> updatePurchaseOrder(@RequestBody PurchaseOrder p) {
          PurchaseOrder purchaseOrder = purchaseOrderService.updatePurchaseOrder(p);
          return new ResponseEntity<>(purchaseOrder, HttpStatus.OK);
     }

     @PutMapping("/add-product")
     public ResponseEntity<PurchaseOrder> addProductToPurchaseOrder (
             @RequestParam String purchaseOrderId,
             @RequestParam String purchaseProductId) {
          PurchaseOrder purchaseOrder = purchaseOrderService.addProductToPurchaseOrder(purchaseOrderId, purchaseProductId);
          return new ResponseEntity<>(purchaseOrder, HttpStatus.OK);
     }


     @DeleteMapping("/{id}")
     public ResponseEntity<?> deletePurchaseOrder(@PathVariable Long id) {
          purchaseOrderService.deletePurchaseOrderById(id);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }
}
