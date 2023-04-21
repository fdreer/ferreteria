package com.franconeta.ferreteria.service;

import com.franconeta.ferreteria.model.PurchaseOrder;

import java.util.List;

public interface IPurchaseOrderService {
     PurchaseOrder createPurchaseOrder(PurchaseOrder p);
     PurchaseOrder updatePurchaseOrder(PurchaseOrder p);
     List<PurchaseOrder> findAllPurchaseOrders();
     PurchaseOrder findPurchaseOrderById(Long id);
     void deletePurchaseOrderById(Long id);
}
