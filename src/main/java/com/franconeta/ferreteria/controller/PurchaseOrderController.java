package com.franconeta.ferreteria.controller;

import com.franconeta.ferreteria.dto.PurchaseOrderDTO;
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
     public ResponseEntity<PurchaseOrderDTO> createPurchaseOrder(@RequestBody PurchaseOrder p) {
          PurchaseOrderDTO purchaseOrder = purchaseOrderService.createPurchaseOrder(p);
          return new ResponseEntity<>(purchaseOrder, HttpStatus.CREATED);
     }

     @GetMapping("/{id}")
     public ResponseEntity<PurchaseOrderDTO> getPurchaseOrder(@PathVariable Long id) {
          PurchaseOrderDTO purchaseOrder = purchaseOrderService.findPurchaseOrderById(id);
          return new ResponseEntity<>(purchaseOrder, HttpStatus.OK);
     }

     @GetMapping
     public ResponseEntity<List<PurchaseOrderDTO>> getAllPurchaseOrders() {
          List<PurchaseOrderDTO> purchaseOrderList = purchaseOrderService.findAllPurchaseOrders();
          return new ResponseEntity<>(purchaseOrderList, HttpStatus.OK);
     }

     @PutMapping
     public ResponseEntity<PurchaseOrderDTO> updatePurchaseOrder(@RequestBody PurchaseOrder p) {
          PurchaseOrderDTO purchaseOrder = purchaseOrderService.updatePurchaseOrder(p);
          return new ResponseEntity<>(purchaseOrder, HttpStatus.OK);
     }

     @PutMapping("/add-product")
     public ResponseEntity<PurchaseOrderDTO> addProductToPurchaseOrder (
             @RequestParam String purchaseOrderId,
             @RequestParam String purchaseProductId) {
          PurchaseOrderDTO purchaseOrder = purchaseOrderService.addProductToPurchaseOrder(purchaseOrderId, purchaseProductId);
          return new ResponseEntity<>(purchaseOrder, HttpStatus.OK);
     }


     @DeleteMapping("/{id}")
     public ResponseEntity<?> deletePurchaseOrder(@PathVariable Long id) {
          purchaseOrderService.deletePurchaseOrderById(id);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }
}
