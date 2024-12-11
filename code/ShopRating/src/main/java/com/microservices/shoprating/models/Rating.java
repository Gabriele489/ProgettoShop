package com.microservices.shoprating.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rating")

public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productId;
    private String userId;
    private Integer rating;
    private String comment;

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", productId='" + productId + '\'' +
                ", userId='" + userId + '\'' +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                '}';
    }
}