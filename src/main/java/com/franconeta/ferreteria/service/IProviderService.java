package com.franconeta.ferreteria.service;

import com.franconeta.ferreteria.model.Provider;

import java.util.List;

public interface IProviderService {
     Provider createProvider(Provider p);
     Provider updateProvider(Provider p);
     List<Provider> findAllProviders();
     Provider findProviderById(Long id);
     void deleteProviderById(Long id);
}
