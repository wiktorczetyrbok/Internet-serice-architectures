package org.example.repository.impl;

import org.example.repository.CityRestRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Repository
public class CityRestRepositoryImpl implements CityRestRepository {

    private final RestTemplate restTemplate;
    private final String deleteUrl;
    public CityRestRepositoryImpl(RestTemplate restTemplate, @Value("${isa.city.url.delete}") String deleteUrl) {
        this.restTemplate = restTemplate;
        this.deleteUrl = deleteUrl;
    }

    @Override
    public void delete(UUID id) {
        restTemplate.delete(deleteUrl);
    }
}
