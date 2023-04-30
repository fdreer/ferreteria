package com.franconeta.ferreteria.controller;

import com.franconeta.ferreteria.dto.ProviderDTO;
import com.franconeta.ferreteria.model.Provider;
import com.franconeta.ferreteria.service.IProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/provider")
public class ProviderController {

     @Autowired
     private IProviderService providerService;

     @PostMapping
     public ResponseEntity<ProviderDTO> createProvider(@RequestBody Provider p) {
          ProviderDTO provider = providerService.createProvider(p);
          return new ResponseEntity<>(provider, HttpStatus.CREATED);
     }

     @GetMapping("/{id}")
     public ResponseEntity<ProviderDTO> getProviderById(@PathVariable Long id) {
          ProviderDTO provider = providerService.findProviderById(id);
          return new ResponseEntity<>(provider, HttpStatus.OK);
     }

     @GetMapping
     public ResponseEntity<List<ProviderDTO>> getAllProviders() {
          List<ProviderDTO> providerList = providerService.findAllProviders();
          return new ResponseEntity<>(providerList, HttpStatus.OK);
     }

     @PutMapping
     public ResponseEntity<ProviderDTO> updateProvider(@RequestBody Provider p) {
          ProviderDTO provider = providerService.updateProvider(p);
          return new ResponseEntity<>(provider, HttpStatus.OK);
     }

     @DeleteMapping("/{id}")
     public ResponseEntity<?> deleteProvider(@PathVariable Long id) {
          providerService.deleteProviderById(id);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }
}
