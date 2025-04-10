package com.maxvone.productservice.services;

import java.util.Optional;

import com.maxvone.productservice.domain.dto.ProductDto;
import com.maxvone.productservice.domain.entities.ProductEntity;

public interface ProductService {

    ProductEntity save(ProductDto productDto);
    Optional<ProductEntity> findById(Long id);

}