package com.maxvone.productservice.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import com.maxvone.productservice.domain.entities.ProductEntity;
import com.maxvone.productservice.mappers.Mapper;
import com.maxvone.productservice.domain.dto.ProductDto;

@Component
public class ProductMapper implements Mapper<ProductEntity, ProductDto> {

    private final ModelMapper modelMapper;

    public ProductMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ProductDto mapTo(ProductEntity productEntity) {
        return modelMapper.map(productEntity, ProductDto.class);
    }

    @Override
    public ProductEntity mapFrom(ProductDto productDto) {
        return modelMapper.map(productDto, ProductEntity.class);
    }
}