package com.iamsajan.ecommerce.service;

import com.iamsajan.ecommerce.dto.ProductResponseDto;
import com.iamsajan.ecommerce.dto.ProductResponseListDto;
import com.iamsajan.ecommerce.entity.Product;
import com.iamsajan.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    private ProductResponseDto getProductResponseDto(Product product) {
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setId(product.getId());
        productResponseDto.setProductCategory(product.getProductCategory());
        productResponseDto.setSku(product.getSku());
        productResponseDto.setName(product.getName());
        productResponseDto.setDescription(product.getDescription());
        productResponseDto.setUnitPrice(product.getUnitPrice());
        productResponseDto.setImageUrl(product.getImageUrl());
        productResponseDto.setActive(product.isActive());
        productResponseDto.setUnitsInStock(product.getUnitsInStock());
        productResponseDto.setDateCreated(product.getDateCreated());
        productResponseDto.setLastUpdated(product.getLastUpdated());

        return productResponseDto;
    }

    public ProductResponseListDto getProducts() {
        List<ProductResponseDto> productResponseDtoList = new ArrayList<>();

        List<Product> products = productRepository.findAll();

        for (Product product : products) {
            productResponseDtoList.add(getProductResponseDto(product));
        }

        ProductResponseListDto response = new ProductResponseListDto();
        response.setProducts(productResponseDtoList);
        response.setTotal((long) products.size());

        return response;
    }

    public ProductResponseDto getProduct(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            return getProductResponseDto(product);
        }
        return null;
    }
}
