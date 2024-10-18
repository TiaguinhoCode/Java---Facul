package com.catalogs.catalogsproducts.model;

import jakarta.persistence.Entity;

@Entity(name = "products")
public class productsModel {

    public Integer stock;
    public Boolean isActive;
    public String description;
    public String urlImage;
    public String brand;

}
