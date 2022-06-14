package com.iamsajan.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductResponseListDto {
    private List<ProductResponseDto> products;
    private Long total;
}
