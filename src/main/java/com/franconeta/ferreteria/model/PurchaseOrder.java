package com.franconeta.ferreteria.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ordenes_de_compras")
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class PurchaseOrder {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     @ManyToMany
     @JoinTable(name = "ordenes_de_compras_purchase_products",
             joinColumns = @JoinColumn(name = "purchase_order_id"),
             inverseJoinColumns = @JoinColumn(name = "purchase_products_id"))
     private List<PurchaseProduct> purchaseProducts = new ArrayList<>();

     @ManyToOne(cascade = CascadeType.ALL)
     @JoinColumn(name = "provider_id")
     private Provider provider;
}
