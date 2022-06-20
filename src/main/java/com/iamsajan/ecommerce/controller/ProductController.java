package com.iamsajan.ecommerce.controller;

import com.iamsajan.ecommerce.dto.ProductResponseDto;
import com.iamsajan.ecommerce.dto.ProductResponseListDto;
import com.iamsajan.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ProductResponseDto getProduct(@PathVariable("id") Long id) {
        return productService.getProduct(id);
    }

    @GetMapping("/search")
    @ResponseStatus(code = HttpStatus.OK)
    public ProductResponseListDto searchProducts(@RequestParam("q") String q) {
        return productService.searchProducts(q);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public ProductResponseListDto getPaginatedProducts(@RequestParam(name = "page", required = false) Integer page, @RequestParam(name = "size", required = false) Integer size) {
        return productService.getPaginatedProducts(page, size);
    }
}
