package com.franconeta.ferreteria.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class PurchaseOrderDTO {
     private Long id;
     private List<PurchaseProductDTO> purchaseProducts;
     private Double totalPrice;
     private String provider;
}
