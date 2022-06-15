package com.iamsajan.ecommerce.service;

import com.iamsajan.ecommerce.dto.ProductCategoryResponseDto;
import com.iamsajan.ecommerce.dto.ProductCategoryResponseListDto;
import com.iamsajan.ecommerce.entity.ProductCategory;
import com.iamsajan.ecommerce.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    public ProductCategoryResponseListDto getCategories() {
        List<ProductCategoryResponseDto> productCategoryResponseDto = new ArrayList<>();

        List<ProductCategory> productCategories = productCategoryRepository.findAll();

        for (ProductCategory productCategory : productCategories) {
            productCategoryResponseDto.add(getProductCategoryResponse(productCategory));
        }

        ProductCategoryResponseListDto productCategoryResponseListDto = new ProductCategoryResponseListDto();
        productCategoryResponseListDto.setProductCategory(productCategoryResponseDto);
        productCategoryResponseListDto.setTotal((long) productCategories.size());

        return productCategoryResponseListDto;
    }

    public ProductCategoryResponseDto getProductCategoryResponse(ProductCategory savedProductCategory) {
        ProductCategoryResponseDto productCategoryResponseDto = new ProductCategoryResponseDto();
        productCategoryResponseDto.setId(savedProductCategory.getId());
        productCategoryResponseDto.setCategoryName(savedProductCategory.getCategoryName());

        return productCategoryResponseDto;
    }
}
