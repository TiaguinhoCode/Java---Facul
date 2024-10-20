package com.catalogs.catalogsproducts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.catalogs.catalogsproducts.products.Product;
import com.catalogs.catalogsproducts.products.ProductRepository;
import com.catalogs.catalogsproducts.products.ProductResponseDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/products")
public class productsController {

    @Autowired
    private ProductRepository repository;

    @GetMapping
    public Map<String, List<ProductResponseDTO>> getAll() {
        List<ProductResponseDTO> productList = repository.findAll().stream()
                .map(ProductResponseDTO::new)
                .toList();

        Map<String, List<ProductResponseDTO>> response = new HashMap<>();
        response.put("products", productList);

        return response;
    }

    @GetMapping("/catalogo") // Novo endpoint para filtrar por marca
    public Map<String, List<ProductResponseDTO>> getByBrand(@RequestParam String brand) {
        List<ProductResponseDTO> filteredProducts = repository.findByBrand(brand).stream()
                .map(ProductResponseDTO::new)
                .toList();

        Map<String, List<ProductResponseDTO>> response = new HashMap<>();
        response.put("products", filteredProducts);

        return response;
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> save(@RequestBody Product product) {
        Product savedProduct = repository.save(product);
        ProductResponseDTO responseDTO = new ProductResponseDTO(savedProduct);

        return ResponseEntity.ok(responseDTO);
    }
}