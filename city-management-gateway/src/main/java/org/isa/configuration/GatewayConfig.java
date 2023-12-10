package org.isa.configuration;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;


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
                        .uri("ds://city-service"))
                .route("citizen_route", r -> r
                        .path("/citizens/**")
                        .uri("ds://citizen-service"))
                .route("city_id_route", r -> r
                        .path("/cities/{id}")
                        .uri("ds://city-service"))
                .route("citizen_id_route", r -> r
                        .path("/citizens/{id}")
                        .uri("ds://citizen-service"))
                .route("fallback_route", r -> r
                        .path("/**")
                        .filters(f -> f.rewritePath("/api(?<remaining>.*)", "/$\\{remaining}"))
                        .uri(host))
                .build();
    }
    @Bean
    public GlobalFilter discoveryFilter(DiscoveryClient discoveryClient) {
        return new GlobalFilter() {
            @Override
            @SneakyThrows
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                URI uri = exchange.getAttribute(ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR);
                if (uri != null && "ds".equals(uri.getScheme())) {
                    System.out.println(uri.getHost());
                    ServiceInstance instance = discoveryClient.getInstances(uri.getHost()).stream()
                            .findFirst()
                            .orElseThrow();
                    System.out.println(instance.getHost());
                    URI newUri = new URI(
                            instance.getScheme(),   // Updated scheme
                            uri.getUserInfo(),      // Keep the original user info
                            instance.getHost(),     // Updated host
                            instance.getPort(),     // Updated port
                            uri.getPath(),          // Keep the original path
                            uri.getQuery(),         // Keep the original query
                            uri.getFragment()       // Keep the original fragment
                    );
                    exchange.getAttributes().put(ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR, newUri);
                }
                return chain.filter(exchange);
            }
        };
    }
}
