package com.microservices.shoprating.repositories;

import com.microservices.shoprating.models.Rating;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    Rating findByProductIdAndUserId(String productId, String userId);

    @Query("SELECT r.productId, AVG(r.rating) as avgRating " +
           "FROM Rating r " +
           "GROUP BY r.productId " +
           "ORDER BY avgRating DESC")
    List<Object[]> findPopularProducts(Pageable pageable);

    Page<Rating> findByProductId(String productId, Pageable pageable);
}