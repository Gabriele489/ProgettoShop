package com.microservices.shoprating.controllers;

import com.microservices.shoprating.models.Rating;
import com.microservices.shoprating.services.RatingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    @Autowired
    private RatingServiceImpl ratingService;

    @PostMapping("/{productId}/{userId}")
    public Rating addOrUpdateRating(@PathVariable String productId, @PathVariable String userId,
                                    @RequestBody Rating rating) {
        return ratingService.addOrUpdateRating(productId, userId, rating.getRating(), rating.getComment());
    }

    @GetMapping("/{productId}")
    public Page<Rating> getRatingsByProductId(@PathVariable String productId, Pageable pageable) {
        return ratingService.getRatingsByProductId(productId, pageable);
    }

    @GetMapping("/popular")
    public List<Object[]> getPopularProducts(Pageable pageable) {
        return ratingService.getPopularProducts(pageable);
    }

    @GetMapping("")
    public List<Rating> getAllRatings() {
        return ratingService.getRatings();
    }
}