package com.franconeta.ferreteria.service.impl;

import com.franconeta.ferreteria.model.Provider;
import com.franconeta.ferreteria.model.PurchaseOrder;
import com.franconeta.ferreteria.model.PurchaseProduct;
import com.franconeta.ferreteria.repository.PurchaseOrderRepository;
import com.franconeta.ferreteria.service.IProviderService;
import com.franconeta.ferreteria.service.IPurchaseOrderService;
import com.franconeta.ferreteria.service.IPurchaseProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PurchaseOrderServiceImpl implements IPurchaseOrderService {

     @Autowired
     private PurchaseOrderRepository purchaseOrderRepository;
     @Autowired
     private IPurchaseProductService purchaseProductService;
     @Autowired
     private IProviderService providerService;

     @Override
     public PurchaseOrder createPurchaseOrder(PurchaseOrder p) {
          Set<PurchaseProduct> products = p.getPurchaseProducts();
          Set<PurchaseProduct> productsToSave = new HashSet<>();

          for (PurchaseProduct product : products) {
               PurchaseProduct productFind = purchaseProductService.findPurchaseProductById(product.getId());
               productsToSave.add(productFind);
          }
          Provider providerFind = providerService.findProviderById(p.getProvider().getId());

          p.setPurchaseProducts(productsToSave);
          p.setProvider(providerFind);
          return purchaseOrderRepository.save(p);
     }

     @Override
     public PurchaseOrder updatePurchaseOrder(PurchaseOrder p) {
          return this.createPurchaseOrder(p);
     }

     @Override
     public PurchaseOrder addProductToPurchaseOrder(String purchaseOrderId, String purchaseProductId) {
          PurchaseOrder purchaseOrder = findPurchaseOrderById(Long.parseLong(purchaseOrderId));
          PurchaseProduct purchaseProduct = purchaseProductService.findPurchaseProductById(Long.parseLong(purchaseProductId));
          purchaseOrder.getPurchaseProducts().add(purchaseProduct);
          return purchaseOrderRepository.save(purchaseOrder);
     }

     @Override
     public List<PurchaseOrder> findAllPurchaseOrders() {
          return purchaseOrderRepository.findAll();
     }

     @Override
     public PurchaseOrder findPurchaseOrderById(Long id) {
          Optional<PurchaseOrder> purchaseOrderOPT = purchaseOrderRepository.findById(id);
          return purchaseOrderOPT.get();
     }

     @Override
     public void deletePurchaseOrderById(Long id) {
          purchaseOrderRepository.deleteById(id);
     }
}
