package com.catalogs.catalogsproducts.sellers;

import com.catalogs.catalogsproducts.models.sellers.sellers;

public record sellersResponseDTO(Long id, String name, String company, String phone_number, Boolean isActive) {

    public sellersResponseDTO(sellers sellers) {
        this(sellers.getId(), sellers.getName(), sellers.getCompany(), sellers.getPhone_number(), sellers.getIsActive());
    }
}
