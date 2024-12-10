package com.microservices.shop_rating.models;

import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.*;

@Entity
@Table(name = "ratings")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Default constructor
    public Rating() {}

    // Argument constructor
    public Rating(Long productId, Long userId, int voto, String commento) {
        this.productId = productId;
        this.userId = userId;
        this.voto = voto;
        this.commento = commento;
    }
    private Long productId;
    private Long userId;
    private int voto;
    private String commento;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    public String getCommento() {
        return commento;
    }

    public void setCommento(String commento) {
        this.commento = commento;
    }
}
