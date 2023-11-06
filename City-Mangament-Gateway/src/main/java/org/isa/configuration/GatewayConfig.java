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
        RouteLocator routeLocator = builder
                .routes()
                .route("citizen", route -> route
                        .host(host)
                        .and()
                        .path(
                                "/citizen/{id}",
                                "/citizen"
                        )
                        .uri(citizenUrl)
                )
                .route("city", route -> route
                        .host(host)
                        .and()
                        .path(
                                "/city",
                                "/city/{id}"
                        )
                        .uri(cityUrl)
                )
                .build();

        routeLocator.getRoutes().subscribe(route -> {
            System.out.println("Route ID: " + route.getId());
            System.out.println("Route URI: " + route.getUri());
            System.out.println("Route Predicates: " + route.getPredicate());
            System.out.println("Route Filters: " + route.getFilters());
        });

        return routeLocator;
    }

}
