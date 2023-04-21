package com.franconeta.ferreteria.controller;

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
     public ResponseEntity<Provider> createProvider(@RequestBody Provider p) {
          Provider provider = providerService.createProvider(p);
          return new ResponseEntity<>(provider, HttpStatus.CREATED);
     }

     @GetMapping("/{id}")
     public ResponseEntity<Provider> getProviderById(@PathVariable Long id) {
          Provider provider = providerService.findProviderById(id);
          return new ResponseEntity<>(provider, HttpStatus.OK);
     }

     @GetMapping
     public ResponseEntity<List<Provider>> getAllProviders() {
          List<Provider> providerList = providerService.findAllProviders();
          return new ResponseEntity<>(providerList, HttpStatus.OK);
     }

     @PutMapping
     public ResponseEntity<Provider> updateProvider(@RequestBody Provider p) {
          Provider provider = providerService.updateProvider(p);
          return new ResponseEntity<>(provider, HttpStatus.OK);
     }

     @DeleteMapping("/{id}")
     public ResponseEntity<?> deleteProvider(@PathVariable Long id) {
          providerService.deleteProviderById(id);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }
}
