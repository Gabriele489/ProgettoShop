package com.microservices.shop_rating.repositories;

import com.microservices.shop_rating.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findByProductId(Long productId);
    Optional<Rating> findByProductIdAndUserId(Long productId, Long userId);
    
}
