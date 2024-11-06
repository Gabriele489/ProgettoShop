package com.microservices.catalog.controllers;

import com.microservices.catalog.models.Product;
import com.microservices.catalog.services.interfaces.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category) {
        return productService.getProductsByCategory(category);
    }

    @GetMapping("/code/{code}")
    public Optional<Product> getProductByCode(@PathVariable String code) {
        return productService.getProductByCode(code);
    }

    @PostMapping("")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}/availability/{value}")
    public Product updateAvailability(@PathVariable Long id,
                                      @PathVariable Integer value) {
        return productService.updateAvailability(id, value);
    }
}