package org.example.utils;

import jakarta.annotation.PostConstruct;
import org.example.model.City;
import org.example.repository.CityRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class DataLoader {


    private final CityRepository cityRepository;

    public DataLoader(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    private static List<City> loadCities() {
        List<City> listOfCities = new ArrayList<>();
        listOfCities.add(City.builder().id(UUID.fromString("e340ba5d-de57-47db-a56f-5bd788f4d183"))
                .name("Gdansk").area(21312321).build());

        listOfCities.add(City.builder().id(UUID.fromString("3851dc62-52b7-481a-adcd-0287c16298b5"))
                .name("Torun").area(15756657).build());

        listOfCities.add(City.builder().id(UUID.fromString("fd08d341-a0b4-4a32-8251-903178a6daa4"))
                .name("Gizyko").area(30232133).build());

        listOfCities.add(City.builder().id(UUID.fromString("df6dfefa-107d-4791-84be-f548b1a9a902"))
                .name("Krakow").area(10123123).build());

        return listOfCities;
    }

    @PostConstruct
    public void persistData() {
        List<City> listOfCities = DataLoader.loadCities();
        cityRepository.saveAll(listOfCities);
    }
}
