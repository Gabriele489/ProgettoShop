package com.microservices.shopgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopGatewayApplication.class, args);
    }


//    @Bean
//    @Profile("!test")
//    public MongoClient getMongoClient() {
//        CommandListener listener = MongoDBTracing.create(Tracing.current())
//                .commandListener();
//
//        MongoClientSettings settings = MongoClientSettings.builder()
//                .applyConnectionString(new ConnectionString(mongoUri))
//                .addCommandListener(listener).build();
//        return MongoClients.create(settings);
//    }
}
