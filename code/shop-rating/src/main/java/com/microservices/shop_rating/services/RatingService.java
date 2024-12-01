package main.java.com.microservices.shop_rating.services;

import com.example.shoprating.model.Rating;
import com.example.shoprating.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {
    @Autowired
    private RatingRepository ratingRepository;

    public Rating addOrUpdateRating(Long productId, Long userId, int voto, String commento) {
        Optional<Rating> existingRating = ratingRepository.findByProductIdAndUserId(productId, userId);
        Rating rating = existingRating.orElse(new Rating());
        rating.setProductId(productId);
        rating.setUserId(userId);
        rating.setVoto(voto);
        rating.setCommento(commento);
        return ratingRepository.save(rating);
    }

    public List<Rating> getRatingsByProductId(Long productId) {
        return ratingRepository.findByProductId(productId);
    }

    public List<ProductRating> getPopularProducts(Pageable pageable) {
        // Implementa la logica per ottenere i prodotti con il voto medio più alto
        return ratingRepository.findAll(pageable).stream()
            .collect(Collectors.groupingBy(Rating::getProductId, Collectors.averagingDouble(Rating::getVoto)))
            .entrySet().stream()
            .sorted(Map.Entry.<Long, Double>comparingByValue().reversed())
            .map(entry -> new ProductRating(entry.getKey(), entry.getValue()))
            .collect(Collectors.toList());
    }
}
