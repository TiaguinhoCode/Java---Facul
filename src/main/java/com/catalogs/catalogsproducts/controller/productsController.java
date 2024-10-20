package com.catalogs.catalogsproducts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalogs.catalogsproducts.products.Product;
import com.catalogs.catalogsproducts.products.ProductRepository;
import com.catalogs.catalogsproducts.products.ProductResponseDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map; // Importar Map

@RestController
@RequestMapping("/v1/products")
public class productsController { // Corrigir a capitalização do nome da classe

    @Autowired
    private ProductRepository repository;

    @GetMapping
    public Map<String, List<ProductResponseDTO>> getAll() {
        List<ProductResponseDTO> productList = repository.findAll().stream()
                .map(ProductResponseDTO::new)
                .toList();

        Map<String, List<ProductResponseDTO>> response = new HashMap<>(); // Criar um novo mapa
        response.put("products", productList); // Adicionar a lista ao mapa com a chave "products"

        return response; // Retornar o mapa como resposta
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> save(@RequestBody Product product) {
        Product savedProduct = repository.save(product);
        ProductResponseDTO responseDTO = new ProductResponseDTO(savedProduct);

        return ResponseEntity.ok(responseDTO);
    }
}
