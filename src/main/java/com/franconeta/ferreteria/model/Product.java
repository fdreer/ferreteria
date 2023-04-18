package com.franconeta.ferreteria.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "productos")
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Product {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String name;

     @ManyToOne(cascade = CascadeType.ALL)
     @JoinColumn(name = "category_id")
     private Category category;
}
