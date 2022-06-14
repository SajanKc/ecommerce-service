package com.iamsajan.ecommerce.controller;

import com.iamsajan.ecommerce.dto.ProductResponseDto;
import com.iamsajan.ecommerce.dto.ProductResponseListDto;
import com.iamsajan.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public ProductResponseListDto getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ProductResponseDto getProduct(@PathVariable("id") Long id) {
        return productService.getProduct(id);
    }
}
