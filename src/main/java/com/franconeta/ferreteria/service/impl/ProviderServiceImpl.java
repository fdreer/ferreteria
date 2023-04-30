package com.franconeta.ferreteria.service.impl;

import com.franconeta.ferreteria.dto.ProviderDTO;
import com.franconeta.ferreteria.model.Provider;
import com.franconeta.ferreteria.repository.ProviderRepository;
import com.franconeta.ferreteria.service.IProviderService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProviderServiceImpl implements IProviderService {
     @Autowired
     private ProviderRepository providerRepository;

     private ProviderDTO convertToDTO(Provider provider) {
          return new ProviderDTO(
                  provider.getId(),
                  provider.getName()
          );
     }

     @Override
     public ProviderDTO createProvider(Provider p) {
          if (providerRepository.existsByName(p.getName())) {
               throw new EntityExistsException("El proveedor " + p.getName() + " ya existe");
          }
          Provider providerSave = providerRepository.save(p);
          return convertToDTO(providerSave);
     }

     @Override
     public ProviderDTO updateProvider(Provider p) {
          return createProvider(p);
     }

     @Override
     public List<ProviderDTO> findAllProviders() {
          return providerRepository.findAll()
                  .stream().map(provider -> convertToDTO(provider))
                  .collect(Collectors.toList());
     }

     @Override
     public ProviderDTO findProviderById(Long id) {
          return providerRepository.findById(id)
                  .map(provider -> convertToDTO(provider))
                  .orElseThrow(() -> new EntityNotFoundException("El proveedor con id " + id + " no existe"));
     }

     @Override
     public Provider findProviderModelById(Long id) {
          return providerRepository.findById(id)
                  .orElseThrow(() -> new EntityNotFoundException("El proveedor con id " + id + " no existe"));
     }

     @Override
     public void deleteProviderById(Long id) {
          findProviderById(id);
          providerRepository.deleteById(id);
     }
}
