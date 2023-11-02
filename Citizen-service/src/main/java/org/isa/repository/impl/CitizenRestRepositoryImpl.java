package org.isa.repository.impl;

import org.isa.repository.CitizenRestRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Repository
public class CitizenRestRepositoryImpl implements CitizenRestRepository {
    private final RestTemplate restTemplate;
    private final String deleteUrl;
    public CitizenRestRepositoryImpl(RestTemplate restTemplate, @Value("${isa.citizen.url.delete}") String deleteUrl) {
        this.restTemplate = restTemplate;
        this.deleteUrl = deleteUrl;
    }
    @Override
    public void delete(UUID id) {
        restTemplate.delete(deleteUrl, id);

    }
}
