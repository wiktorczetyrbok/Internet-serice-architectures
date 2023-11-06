package org.example.repository;

import org.example.dto.CityDto;

import java.util.UUID;

public interface CityRestRepository {
    void delete(UUID id);

    void updateName(CityDto cityDto);

    void addCity(CityDto cityDto);
}
