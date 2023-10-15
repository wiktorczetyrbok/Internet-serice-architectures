package org.example.mapper;

import org.example.dto.CityDto;
import org.example.model.City;

public class CityMapper {
    public static City mapToCity(CityDto cityDto){
            return City.builder()
                    .id(cityDto.getId())
                    .area(cityDto.getArea())
                    .name(cityDto.getName())
                    .citizens(cityDto.getCitizens())
                    .build();
    }
    public static CityDto mapToCityDto(City city){
            return CityDto.builder()
                    .id(city.getId())
                    .area(city.getArea())
                    .name(city.getName())
                    .citizens(city.getCitizens())
                    .build();
    }


}
