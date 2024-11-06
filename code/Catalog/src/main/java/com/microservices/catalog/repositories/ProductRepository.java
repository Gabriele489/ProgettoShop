package com.microservices.catalog.repositories;

import com.microservices.catalog.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByCode(String code);

    List<Product> findByCategory(String category);
}