package com.iamsajan.ecommerce.controller;

import com.iamsajan.ecommerce.dto.ProductCategoryResponseListDto;
import com.iamsajan.ecommerce.dto.ProductResponseListDto;
import com.iamsajan.ecommerce.service.ProductCategoryService;
import com.iamsajan.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/category")
public class ProductCategoryController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ProductResponseListDto getProductsByCategory(@PathVariable("id") Long id) {
        return productService.getProductsByCategory(id);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public ProductCategoryResponseListDto getCategories() {
        return productCategoryService.getCategories();
    }
}
