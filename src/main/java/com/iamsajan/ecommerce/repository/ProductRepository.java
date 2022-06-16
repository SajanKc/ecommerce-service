package com.iamsajan.ecommerce.repository;

import com.iamsajan.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByProductCategoryId(Long id);

    List<Product> findByNameContaining(String q);

//    Page<Product> findByProductCategoryId(@RequestParam("id") Long id, Pageable pageable);
}
