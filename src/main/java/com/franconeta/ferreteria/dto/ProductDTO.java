package com.franconeta.ferreteria.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class ProductDTO {
     private Long id;
     private String name;
     private String category;
}
