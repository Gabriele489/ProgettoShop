package com.microservices.shoprating;

import com.microservices.shoprating.models.Rating;
import com.microservices.shoprating.repositories.RatingRepository;
import com.microservices.shoprating.services.RatingServiceImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ShopRatingApplicationTests {

    @Autowired
    private RatingServiceImpl ratingService;

    @Autowired
    private RatingRepository ratingRepository;

    @Test
    public void testAddOrUpdateRating() {
        Rating rating = ratingService.addOrUpdateRating("1L", "1L", 5, "Great product!");
        assertNotNull(rating);
        assertEquals(5, rating.getRating());
        assertEquals("Great product!", rating.getComment());
    }

    @Test
    public void testGetRatingsByProductId() {
        Page<Rating> ratings = ratingService.getRatingsByProductId("1L", PageRequest.of(0, 10));
        assertNotNull(ratings);
        assertTrue(ratings.getTotalElements() > 0);
    }

    @Test
    @Disabled
    public void testGetPopularProducts() {
        List<Object[]> popularProducts = ratingService.getPopularProducts(PageRequest.of(0, 10));
        assertNotNull(popularProducts);
        assertTrue(popularProducts.size() > 0);
    }
}