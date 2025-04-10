package com.maxvone.productservice.domain.dto;

import com.maxvone.productservice.domain.entities.ProductEntity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Category category;
    private Integer stock;
}