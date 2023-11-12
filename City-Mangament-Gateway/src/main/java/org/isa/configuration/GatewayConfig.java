package org.isa.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GatewayConfig {
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
                        .uri(host))
                .build();
    }
}
