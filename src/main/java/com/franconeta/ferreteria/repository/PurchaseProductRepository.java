package com.franconeta.ferreteria.repository;

import com.franconeta.ferreteria.model.PurchaseProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PurchaseProductRepository extends JpaRepository<PurchaseProduct, Long> {

//     METODO PARA OBTENER EL STOCK SIN LOS PRECIOS DE LOS PRODUCTOS
}
