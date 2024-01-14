package org.isa.mapper;


import org.isa.dto.citizen.GetCityResponse;
import org.isa.model.City;

public class CityMapper {

    public static City mapToCity(GetCityResponse getCityResponse) {
        return City.builder()
                .id(getCityResponse.getId())
                .name(getCityResponse.getName())
                .build();
    }

    public static GetCityResponse mapToGetCityResponse(City city) {
        return GetCityResponse.builder()
                .id(city.getId())
                .name(city.getName())
                .build();
    }
}
