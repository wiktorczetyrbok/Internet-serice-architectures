package org.example.repository.impl;

import org.example.configuration.CityRestApiUrl;
import org.example.dto.GetCityResponse;
import org.example.dto.PutCityRequest;
import org.example.repository.CityRestRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@Repository
public class CityRestRepositoryImpl implements CityRestRepository {

    private final RestTemplate restTemplate;
    private final CityRestApiUrl restApiUrl;

    public CityRestRepositoryImpl(RestTemplate restTemplate, CityRestApiUrl restApiUrl) {
        this.restTemplate = restTemplate;
        this.restApiUrl = restApiUrl;
    }

    @Override
    public void delete(UUID id) {
        restTemplate.delete(restApiUrl.getDeleteUrl(), id);
    }

    @Override
    public void updateName(UUID id, PutCityRequest putCityRequest) {
        String url = UriComponentsBuilder.fromUriString(restApiUrl.getPutUrl())
                .pathSegment("{id}")
                .buildAndExpand(id)
                .toUriString();

        restTemplate.put(url, putCityRequest);
    }

    @Override
    public void addCity(GetCityResponse getCityResponse) {
        restTemplate.postForLocation(restApiUrl.getPostUrl(), getCityResponse);
    }
}
