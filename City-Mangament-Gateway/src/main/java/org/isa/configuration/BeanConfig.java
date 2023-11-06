package org.isa.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public RouteLocator routeLocator(
            RouteLocatorBuilder builder,
            @Value("${isa.city.url}") String cityUrl,
            @Value("${isa.citizen.url}") String citizenUrl,
            @Value("${isa.gateway.host}") String host) {
        return builder
                .routes()
                .route("citizens", route -> route
                        .host(host)
                        .and()
                        .path(
                                "/citizens/{uuid}",
                                "/citizens"
                        )
                        .uri(citizenUrl)
                )
                .route("city", route -> route
                        .host(host)
                        .and()
                        .path(
                                "/city",
                                "/city/**",
                                "/city/{uuid}/citizen",
                                "/city/{uuid}/characters/**"
                        )
                        .uri(cityUrl)
                )
                .build();
    }
}
