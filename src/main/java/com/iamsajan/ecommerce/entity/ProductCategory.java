package com.iamsajan.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product_category")
@Getter
@Setter
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoryName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productCategory")
    @JsonIgnore
    private Set<Product> products;

}
