package org.isa.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;

import java.util.Arrays;
import java.util.Collections;


@Configuration
public class GatewayConfig {
    @CrossOrigin(origins = "http://localhost:4200")

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder,
                                     @Value("${isa.city.url}") String cityUrl,
                                     @Value("${isa.citizen.url}") String citizenUrl,
                                     @Value("${isa.gateway.host}") String host) {
        return builder.routes()
                .route("city_route", r -> r
                        .path("/cities/**")
                        .uri(cityUrl))
                .route("citizen_route", r -> r
                        .path("/citizens/**")
                        .uri(citizenUrl))
                .route("city_id_route", r -> r
                        .path("/cities/{id}")
                        .uri(cityUrl))
                .route("citizen_id_route", r -> r
                        .path("/citizens/{id}")
                        .uri(citizenUrl))
                .route("fallback_route", r -> r
                        .path("/**")
                        .filters(f -> f.rewritePath("/api(?<remaining>.*)", "/$\\{remaining}"))
                        .uri(host))
                .build();
    }
}
