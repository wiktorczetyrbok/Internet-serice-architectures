package org.example.mapper;

import org.example.dto.GetCitiesResponse;
import org.example.dto.GetCityResponse;
import org.example.model.City;

import java.util.List;

public class CityMapper {

    public static City mapToCity(GetCityResponse getCityResponse) {
        return City.builder()
                .id(getCityResponse.getId())
                .area(getCityResponse.getArea())
                .name(getCityResponse.getName())
                .build();
    }

    public static GetCityResponse mapToGetCityResponse(City city) {
        return GetCityResponse.builder()
                .id(city.getId())
                .area(city.getArea())
                .name(city.getName())
                .build();
    }

    public static GetCitiesResponse mapToGetCitiesResponse(List<City> cities) {
        return GetCitiesResponse.builder()
                .getCityResponses(cities.stream()
                        .map(CityMapper::mapToGetCityResponse)
                        .toList())
                .build();
    }

}
