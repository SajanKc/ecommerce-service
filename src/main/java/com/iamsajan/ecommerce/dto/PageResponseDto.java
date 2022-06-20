package com.iamsajan.ecommerce.dto;

import lombok.Data;

@Data
public class PageResponseDto {
    private int size;
    private int pageNumber;
    private int totalElement;
    private int totalPages;
}
