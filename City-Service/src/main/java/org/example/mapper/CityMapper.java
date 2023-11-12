package org.example.mapper;

import org.example.dto.GetCityResponse;
import org.example.model.City;

public class CityMapper {

    public static City mapToCity(GetCityResponse getCityResponse) {
        return City.builder()
                .id(getCityResponse.getId())
                .area(getCityResponse.getArea())
                .name(getCityResponse.getName())
                .build();
    }

    public static GetCityResponse mapToCityDto(City city) {
        return GetCityResponse.builder()
                .id(city.getId())
                .area(city.getArea())
                .name(city.getName())
                .build();
    }
}
