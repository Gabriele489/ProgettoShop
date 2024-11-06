package com.microservices.order.repositories;

import com.microservices.order.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, String> {
    List<Order> findByUserId(String userId);

    Optional<Order> findByUserIdAndId(String userId, String id);
}