package main.java.com.microservices.shop_rating.controllers;

import com.example.shoprating.model.Rating;
import com.example.shoprating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @PostMapping("/{productId}/{userId}")
    public ResponseEntity<Rating> addOrUpdateRating(@PathVariable Long productId, @PathVariable Long userId, @RequestBody Rating rating) {
        Rating savedRating = ratingService.addOrUpdateRating(productId, userId, rating.getVoto(), rating.getCommento());
        return ResponseEntity.ok(savedRating);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<List<Rating>> getRatingsByProductId(@PathVariable Long productId) {
        List<Rating> ratings = ratingService.getRatingsByProductId(productId);
        return ResponseEntity.ok(ratings);
    }

    @GetMapping("/popular")
    public ResponseEntity<List<ProductRating>> getPopularProducts(Pageable pageable) {
        List<ProductRating> popularProducts = ratingService.getPopularProducts(pageable);
        return ResponseEntity.ok(popularProducts);
    }
}
