package org.isa.mapper;


import org.isa.dto.CityDto;
import org.isa.model.City;

public class CityMapper {

    public static City mapToCity(CityDto cityDto) {
        return City.builder()
                .id(cityDto.getId())
                .name(cityDto.getName())
                .build();
    }

    public static CityDto mapToCityDto(City city) {
        return CityDto.builder()
                .id(city.getId())
                .name(city.getName())
                .build();
    }
}
