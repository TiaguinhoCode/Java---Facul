package com.catalogs.catalogsproducts.products;

import com.catalogs.catalogsproducts.models.products.Product;

public record ProductResponseDTO(long id, String stock, Boolean is_active, String description, String urlImagem,
        String brand, Integer price) {

    public ProductResponseDTO(Product product) {
        this(product.getId(), product.getStock(), product.is_active(), product.getDescription(),
                product.getUrlImagem(), product.getBrand(), product.getPrice());
    }
}

