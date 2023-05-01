package com.franconeta.ferreteria.service;

import com.franconeta.ferreteria.dto.PurchaseOrderDTO;
import com.franconeta.ferreteria.model.PurchaseOrder;

import java.util.List;

public interface IPurchaseOrderService {
     PurchaseOrderDTO createPurchaseOrder(PurchaseOrder p);
     PurchaseOrderDTO updatePurchaseOrder(PurchaseOrder p);
     PurchaseOrderDTO addProductToPurchaseOrder(String purchaseOrderId, String purchaseProductId);
     List<PurchaseOrderDTO> findAllPurchaseOrders();
     PurchaseOrderDTO findPurchaseOrderById(Long id);
     PurchaseOrder findPurchaseOrderModelById(Long id);
     void deletePurchaseOrderById(Long id);
}
