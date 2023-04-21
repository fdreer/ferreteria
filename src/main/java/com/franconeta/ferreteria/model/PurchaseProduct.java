package com.franconeta.ferreteria.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "productos_comprados")
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class PurchaseProduct {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id")
     private Long id;

     @ManyToOne
     @JoinColumn(name = "product_id")
     private Product product;

     private Double price;
     private Integer units;
}
