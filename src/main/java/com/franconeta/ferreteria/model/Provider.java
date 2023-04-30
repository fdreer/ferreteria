package com.franconeta.ferreteria.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "proveedores")
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Provider {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     private String name;

     @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL)
     private Set<PurchaseOrder> purchaseOrders = new HashSet<>();
}
