package com.franconeta.ferreteria.repository;

import com.franconeta.ferreteria.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {
     Boolean existsByName(String name);
}