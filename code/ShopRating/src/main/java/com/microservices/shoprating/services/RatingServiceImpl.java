package com.microservices.shoprating.services;

import com.microservices.shoprating.models.Rating;
import com.microservices.shoprating.repositories.RatingRepository;
import com.microservices.shoprating.services.interfaces.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public List<Rating> getRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public Rating addOrUpdateRating(String productId, String userId, Integer rating, String comment) {
        Rating existingRating = ratingRepository.findByProductIdAndUserId(productId, userId);
        if (existingRating != null) {
            existingRating.setRating(rating);
            existingRating.setComment(comment);
            return ratingRepository.save(existingRating);
        } else {
            Rating newRating = new Rating();
            newRating.setProductId(productId);
            newRating.setUserId(userId);
            newRating.setRating(rating);
            newRating.setComment(comment);
            return ratingRepository.save(newRating);
        }
    }

    @Override
    public Page<Rating> getRatingsByProductId(String productId, Pageable pageable) {
        return ratingRepository.findByProductId(productId, pageable);
    }

    @Override
    public List<Object[]> getPopularProducts(Pageable pageable) {
        return ratingRepository.findPopularProducts(pageable);
    }
}