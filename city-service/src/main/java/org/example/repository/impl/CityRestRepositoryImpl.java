package org.example.repository.impl;

import lombok.RequiredArgsConstructor;
import org.example.configuration.CityRestApiUrl;
import org.example.dto.GetCityResponse;
import org.example.dto.PutCityRequest;
import org.example.repository.CityRestRepository;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CityRestRepositoryImpl implements CityRestRepository {

    private final RestTemplate restTemplate;
    private final CityRestApiUrl restApiUrl;
    private final DiscoveryClient discoveryClient;


    @Override
    public void delete(UUID id) {
        restTemplate.delete(getCitizenServiceUri() + restApiUrl.getDeleteUrl(), id);
    }

    @Override
    public void updateName(UUID id, PutCityRequest putCityRequest) {
        String url = UriComponentsBuilder.fromUriString(restApiUrl.getPutUrl())
                .pathSegment("{id}")
                .buildAndExpand(id)
                .toUriString();

        restTemplate.put(getCitizenServiceUri() + url, putCityRequest);
    }

    @Override
    public void addCity(GetCityResponse getCityResponse) {
        restTemplate.postForLocation(getCitizenServiceUri() +restApiUrl.getPostUrl(), getCityResponse);
    }
    private String getCitizenServiceUri() {
        return discoveryClient.getInstances("citizen-service").stream()
                .findFirst()
                .orElseThrow()
                .getUri()
                .toString();
    }
}
