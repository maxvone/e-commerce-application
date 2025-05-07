package com.maxvone.userservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDtoTemp {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private String category;
    private Integer stock;
}
