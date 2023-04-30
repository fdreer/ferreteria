package com.franconeta.ferreteria.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
public class PurchaseProductDTO {
     private Long id;
     private String name;
     private Double price;
     private Integer units;
     private Double totalPrice;
     private Boolean received;
}
