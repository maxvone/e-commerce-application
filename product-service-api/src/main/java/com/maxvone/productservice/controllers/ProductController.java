package com.maxvone.productservice.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxvone.productservice.domain.dto.ProductDto;
import com.maxvone.productservice.domain.entities.ProductEntity;
import com.maxvone.productservice.mappers.Mapper;
import com.maxvone.productservice.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productService;
    private Mapper<ProductEntity, ProductDto> productMapper;
    
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        ProductEntity savedProductEntity = productService.save(productDto);
        return new ResponseEntity<>(productMapper.mapTo(savedProductEntity), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(Long id) {
        Optional<ProductEntity> foundProduct = productService.findById(id);
        
        return foundProduct.map(product -> {
            ProductDto productDto = productMapper.mapTo(product);
            return new ResponseEntity<>(productDto, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
