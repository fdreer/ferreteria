package com.franconeta.ferreteria.service;

import com.franconeta.ferreteria.dto.ProviderDTO;
import com.franconeta.ferreteria.model.Provider;

import java.util.List;

public interface IProviderService {
     ProviderDTO createProvider(Provider p);
     ProviderDTO updateProvider(Provider p);
     List<ProviderDTO> findAllProviders();
     ProviderDTO findProviderById(Long id);
     Provider findProviderModelById(Long id);
     void deleteProviderById(Long id);
}
