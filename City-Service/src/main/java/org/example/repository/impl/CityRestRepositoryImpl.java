package org.example.repository.impl;

import org.example.configuration.CityRestApiUrl;
import org.example.dto.CityDto;
import org.example.repository.CityRestRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

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
    public void updateName(CityDto cityDto) {
        restTemplate.put(restApiUrl.getPutUrl(), cityDto);
    }

    @Override
    public void addCity(CityDto cityDto) {
        restTemplate.postForLocation(restApiUrl.getPostUrl(), cityDto);
    }
}
