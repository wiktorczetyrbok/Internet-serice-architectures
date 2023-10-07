package org.example;

public class Mapper {
    public static CitizenDto mapToCitizenDto(Citizen citizen) {

        return CitizenDto.builder()
                .cityName(citizen.getCity().getName())
                .name(citizen.getName())
                .cost(citizen.getAge())
                .build();
    }
}
