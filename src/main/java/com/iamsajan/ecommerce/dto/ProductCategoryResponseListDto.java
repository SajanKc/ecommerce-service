package com.iamsajan.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductCategoryResponseListDto {
    private List<ProductCategoryResponseDto> productCategory;
    private Long total;
}
