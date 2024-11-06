package com.microservices.catalog.services.interfaces;

import com.microservices.catalog.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getProducts();
    Optional<Product> getProductById(Long id);
    Optional<Product> getProductByCode(String code);
    List<Product> getProductsByCategory(String category);
    Product createProduct(Product product);
    Product updateAvailability(Long id, Integer availability);
}