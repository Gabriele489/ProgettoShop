package com.microservices.shop_rating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan(basePackages = "com.microservices.shop_rating.models")
public class ShopRatingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopRatingApplication.class, args);
	}

}