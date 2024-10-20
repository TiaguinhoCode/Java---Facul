package com.catalogs.catalogsproducts.products;

public record ProductResponseDTO(long id, String stock, Boolean isActive, String description, String urlImagem,
        String brand, Integer price) {

    public ProductResponseDTO(Product product) {
        this(product.getId(), product.getStock(), product.isActive(), product.getDescription(),
                product.getUrlImagem(), product.getBrand(), product.getPrice());
    }
}
