package com.franconeta.ferreteria.service;

import com.franconeta.ferreteria.dto.PurchaseProductDTO;
import com.franconeta.ferreteria.model.PurchaseProduct;

import java.util.List;

public interface IPurchaseProductService {
     PurchaseProductDTO createPurchaseProduct(PurchaseProduct p);
     PurchaseProductDTO updatePurchaseProduct(PurchaseProduct p);
     List<PurchaseProductDTO> findAllPurchaseProducts();
     PurchaseProductDTO findPurchaseProductById(Long id);
     void deletePurchaseProductById(Long id);
}
