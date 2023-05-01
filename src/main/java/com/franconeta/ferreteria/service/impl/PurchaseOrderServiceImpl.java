package com.franconeta.ferreteria.service.impl;

import com.franconeta.ferreteria.dto.PurchaseOrderDTO;
import com.franconeta.ferreteria.dto.PurchaseProductDTO;
import com.franconeta.ferreteria.model.Provider;
import com.franconeta.ferreteria.model.PurchaseOrder;
import com.franconeta.ferreteria.model.PurchaseProduct;
import com.franconeta.ferreteria.repository.PurchaseOrderRepository;
import com.franconeta.ferreteria.service.IProviderService;
import com.franconeta.ferreteria.service.IPurchaseOrderService;
import com.franconeta.ferreteria.service.IPurchaseProductService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PurchaseOrderServiceImpl implements IPurchaseOrderService {

     @Autowired
     private PurchaseOrderRepository purchaseOrderRepository;
     @Autowired
     private IPurchaseProductService purchaseProductService;
     @Autowired
     private IProviderService providerService;

     @Override
     public PurchaseOrderDTO createPurchaseOrder(PurchaseOrder p) {
          List<PurchaseProduct> productsToSave = p.getPurchaseProducts()
                  .stream()
                  .map(purchaseProduct -> purchaseProductService.findPurchaseProductModelById(purchaseProduct.getId()))
                  .toList();

          Provider providerFind = providerService.findProviderModelById(p.getProvider().getId());

          p.setPurchaseProducts(productsToSave);
          p.setProvider(providerFind);

          PurchaseOrder purchaseOrderSave = purchaseOrderRepository.save(p);
          return convertToDTO(purchaseOrderSave);
     }

     private PurchaseOrderDTO convertToDTO(PurchaseOrder purchaseOrder) {
          List<PurchaseProductDTO> listToDTO = purchaseOrder.getPurchaseProducts()
                  .stream().map(purchaseProduct -> convertToDTOPurchaseProduct(purchaseProduct)).toList();

          Double totalPrice = listToDTO.stream().mapToDouble(PurchaseProductDTO::getTotalPrice).sum();
          return new PurchaseOrderDTO(
                  purchaseOrder.getId(),
                  listToDTO,
                  totalPrice,
                  purchaseOrder.getProvider().getName()
          );
     }

     private PurchaseProductDTO convertToDTOPurchaseProduct(PurchaseProduct purchaseProduct) {
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
     public PurchaseOrderDTO updatePurchaseOrder(PurchaseOrder p) {
          return createPurchaseOrder(p);
     }

     @Override
     public PurchaseOrderDTO addProductToPurchaseOrder(String purchaseOrderId, String purchaseProductId) {
          PurchaseOrder purchaseOrder = findPurchaseOrderModelById(Long.parseLong(purchaseOrderId));
          PurchaseProduct purchaseProduct = purchaseProductService.findPurchaseProductModelById(Long.parseLong(purchaseProductId));
          purchaseOrder.getPurchaseProducts().add(purchaseProduct);
          return convertToDTO(purchaseOrderRepository.save(purchaseOrder));
     }

     @Override
     public List<PurchaseOrderDTO> findAllPurchaseOrders() {
          return purchaseOrderRepository.findAll()
                  .stream().map(purchaseOrder -> convertToDTO(purchaseOrder))
                  .collect(Collectors.toList());
     }

     @Override
     public PurchaseOrderDTO findPurchaseOrderById(Long id) {
          return purchaseOrderRepository.findById(id)
                  .map(purchaseOrder -> convertToDTO(purchaseOrder))
                  .orElseThrow(() -> new EntityNotFoundException("La orden de compra con id " + id + "no existe"));
     }

     @Override
     public PurchaseOrder findPurchaseOrderModelById(Long id) {
          return purchaseOrderRepository.findById(id)
                  .orElseThrow(() -> new EntityNotFoundException("La orden de compra con id " + id + "no existe"));
     }

     @Override
     public void deletePurchaseOrderById(Long id) {
          purchaseOrderRepository.deleteById(id);
     }
}
