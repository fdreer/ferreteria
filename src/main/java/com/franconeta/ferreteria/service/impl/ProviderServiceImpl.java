package com.franconeta.ferreteria.service.impl;

import com.franconeta.ferreteria.model.Provider;
import com.franconeta.ferreteria.repository.ProviderRepository;
import com.franconeta.ferreteria.service.IProviderService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProviderServiceImpl implements IProviderService {

     @Autowired
     private ProviderRepository providerRepository;

     @Override
     public Provider createProvider(Provider p) {
          if (providerRepository.existsByName(p.getName())) {
               throw new EntityExistsException("El proveedor " + p.getName() + " ya existe");
          }
          return providerRepository.save(p);
     }

     @Override
     public Provider updateProvider(Provider p) {
          return createProvider(p);
     }

     @Override
     public List<Provider> findAllProviders() {
          return providerRepository.findAll();
     }

     @Override
     public Provider findProviderById(Long id) {
          Optional<Provider> providerOPT = providerRepository.findById(id);
          if (providerOPT.isPresent()) {
               return providerOPT.get();
          }
          throw new EntityNotFoundException("El proveedor con id " + id + " no existe");
     }

     @Override
     public void deleteProviderById(Long id) {
          findProviderById(id);
          providerRepository.deleteById(id);
     }
}
