package org.example.utils;

import jakarta.annotation.PostConstruct;
import org.example.model.City;
import org.example.repository.CityRepository;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DataLoader {


    private final CityRepository cityRepository;

    public DataLoader(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @PostConstruct
    public void persistData() {
        List<City> listOfCities = DataLoader.loadCities();
        cityRepository.saveAll(listOfCities);
    }

    private static List<City> loadCities() {

        List<UUID> uuids = Arrays.asList(
                UUID.fromString("aa2b6af2-3c14-4784-b524-110798769d72"),
                UUID.fromString("1c2b8bdb-f83f-4594-a18b-4073ec5b5afb"),
                UUID.fromString("055555d6-1cd0-4268-a519-176381ed2799"),
                UUID.fromString("8b0454ff-e4f7-4d4d-ae16-4c84162a1c5a"),
                UUID.fromString("445cfb56-ca51-4da3-b244-dfc108460981"),
                UUID.fromString("04dbe36d-e6ca-4030-a3e9-b202967de4cd"),
                UUID.fromString("9d1d3e0a-bb79-4de4-a836-87ca02216846")

        );
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
}
