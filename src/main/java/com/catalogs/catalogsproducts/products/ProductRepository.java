package com.catalogs.catalogsproducts.products;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.catalogs.catalogsproducts.models.products.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByBrand(String brand);
}
