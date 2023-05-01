package com.franconeta.ferreteria.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class PurchaseProductDTO {
     private Long id;
     private String name;
     private Double price;
     private Integer units;
     private Double totalPrice;
     private Boolean received;
}
