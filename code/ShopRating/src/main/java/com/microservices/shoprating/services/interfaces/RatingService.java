package com.microservices.shoprating.services.interfaces;

import com.microservices.shoprating.models.Rating;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RatingService {
    List<Rating> getRatings();
    Rating addOrUpdateRating(String productId, String userId, Integer rating, String comment);
    Page<Rating> getRatingsByProductId(String productId, Pageable pageable);
    List<Object[]> getPopularProducts(Pageable pageable);
}