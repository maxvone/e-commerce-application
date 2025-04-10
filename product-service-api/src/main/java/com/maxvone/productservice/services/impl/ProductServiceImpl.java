package com.maxvone.productservice.services.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.maxvone.productservice.domain.dto.ProductDto;
import com.maxvone.productservice.domain.entities.ProductEntity;
import com.maxvone.productservice.mappers.Mapper;
import com.maxvone.productservice.repositories.ProductRepository;
import com.maxvone.productservice.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
    
    private ProductRepository productRepository;
    private Mapper<ProductEntity, ProductDto> productMapper;

    public ProductServiceImpl(ProductRepository productRepository, Mapper<ProductEntity, ProductDto> productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductEntity save(ProductDto productDto) {
        ProductEntity productEntity = productMapper.mapFrom(productDto);
        ProductEntity savedProductEntity = productRepository.save(productEntity);

        return savedProductEntity;
    }

    @Override
    public Optional<ProductEntity> findById(Long id) {
        return productRepository.findById(id);
    }

}
