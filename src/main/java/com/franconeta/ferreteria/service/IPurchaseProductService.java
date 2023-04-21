package com.franconeta.ferreteria.service;

import com.franconeta.ferreteria.model.PurchaseProduct;

import java.util.List;

public interface IPurchaseProductService {
     PurchaseProduct createPurchaseProduct(PurchaseProduct p);
     PurchaseProduct updatePurchaseProduct(PurchaseProduct p);
     List<PurchaseProduct> findAllPurchaseProducts();
     PurchaseProduct findPurchaseProductById(Long id);
     void deletePurchaseProductById(Long id);
}
