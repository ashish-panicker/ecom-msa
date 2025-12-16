package com.example.apigateway.routes;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {

        /**
         * http://localhost:8080/auth/**           -> http://localhost:8300/api/auth
         * http://localhost:8080/users/**          -> http://localhost:8200/api/users
         * http://localhost:8080/orders/**         -> http://localhost:8000/api/orders
         * http://localhost:8080/inventory/**      -> http://localhost:8100/api/inventory
         *
         * RouteLocatorBuilder, non blocking, uses Reactor netty, does not use servlet stack
         *
         * Strip prefix: Removes one or more path segments from the request url before forwarding it
         * GET: /api/orders/123
         * StripPrefix=2, removes /api and /orders, forwards /123
         */
        return builder
                .routes()

                .route("auth-service-swagger", r -> r
                        .path("/auth/v3/api-docs")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://auth-service"))

                .route("auth-service", r -> r
                        .path("/auth/**")
                        .filters(f -> f.stripPrefix(0).prefixPath("/api"))
                        .uri("lb://auth-service"))

                .route("userprofile-service-swagger", r -> r
                        .path("/users/v3/api-docs")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://userprofile-service"))

                .route("userprofile-service", r -> r
                        .path("/users/**")
                        .filters(f -> f.stripPrefix(0).prefixPath("/api"))
                        .uri("lb://userprofile-service"))

                .route("order-service-swagger", r -> r
                        .path("/orders/v3/api-docs")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://order-service"))

                .route("order-service", r -> r
                        .path("/orders/**")
                        .filters(f -> f.stripPrefix(0).prefixPath("/api"))
                        .uri("lb://order-service"))

                .route("inventory-service-swagger", r -> r
                        .path("/inventory/v3/api-docs")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://inventory-service"))

                .route("inventory-service", r -> r
                        .path("/inventory/**")
                        .filters(f -> f.stripPrefix(0).prefixPath("/api"))
                        .uri("lb://inventory-service"))

                .build();
    }
}
