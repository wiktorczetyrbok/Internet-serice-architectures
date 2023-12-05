package org.example.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(@Value("${isa.citizen-service.url}") String baseUrl) {
        return new RestTemplateBuilder().rootUri(baseUrl).build();
    }
}
