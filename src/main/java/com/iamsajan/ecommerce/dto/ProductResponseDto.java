package com.iamsajan.ecommerce.dto;

import com.iamsajan.ecommerce.entity.ProductCategory;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class ProductResponseDto {
    private Long id;
    private ProductCategory productCategory;
    private String sku;
    private String name;
    private String description;
    private BigDecimal unitPrice;
    private String imageUrl;
    private boolean active;
    private int unitsInStock;
    private Date dateCreated;
    private Date lastUpdated;
}
