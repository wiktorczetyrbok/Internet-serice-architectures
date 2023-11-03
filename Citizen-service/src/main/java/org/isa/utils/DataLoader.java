package org.isa.utils;

import jakarta.annotation.PostConstruct;
import org.isa.model.Citizen;
import org.isa.model.City;
import org.isa.repository.CitizenRepository;
import org.isa.repository.CityRepository;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DataLoader {


    private final CitizenRepository citizenRepository;
    private final CityRepository cityRepository;

    public DataLoader(CitizenRepository citizenRepository, CityRepository cityRepository) {
        this.citizenRepository = citizenRepository;
        this.cityRepository = cityRepository;
    }

    @PostConstruct
    public void persistData() {
        List<City> cities = loadCities();
        List<Citizen> listOfCitizens = DataLoader.loadCitizens(cities);
        loadCitizensToCity(cities, listOfCitizens);
        citizenRepository.saveAll(listOfCitizens);
        cityRepository.saveAll(cities);
    }

    private void loadCitizensToCity(List<City> cities, List<Citizen> listOfCitizens) {
        cities.get(0).setCitizens(Arrays.asList(listOfCitizens.get(0), listOfCitizens.get(1)));
        cities.get(0).setCitizens(Arrays.asList(listOfCitizens.get(2), listOfCitizens.get(3)));
        cities.get(0).setCitizens(Arrays.asList(listOfCitizens.get(4), listOfCitizens.get(5)));
        cities.get(0).setCitizens(Collections.singletonList(listOfCitizens.get(6)));

    }


    private static List<Citizen> loadCitizens(List<City> cities) {
        List<Citizen> listOfCitizens = new ArrayList<>();
        List<UUID> uuids = Arrays.asList(
                UUID.fromString("aa2b6af2-3c14-4784-b524-110798769d72"),
                UUID.fromString("1c2b8bdb-f83f-4594-a18b-4073ec5b5afb"),
                UUID.fromString("055555d6-1cd0-4268-a519-176381ed2799"),
                UUID.fromString("8b0454ff-e4f7-4d4d-ae16-4c84162a1c5a"),
                UUID.fromString("445cfb56-ca51-4da3-b244-dfc108460981"),
                UUID.fromString("04dbe36d-e6ca-4030-a3e9-b202967de4cd"),
                UUID.fromString("9d1d3e0a-bb79-4de4-a836-87ca02216846")

        );
        listOfCitizens.add(Citizen.builder().id(uuids.get(0))
                .name("Jeff Eng").age(24)
                .city(cities.get(0)).build());
        listOfCitizens.add(Citizen.builder().id(uuids.get(1))
                .name("Senthil gopsalym").age(120)
                .city(cities.get(0)).build());
        listOfCitizens.add(Citizen.builder().id(uuids.get(2))
                .name("Wiktor Czetyrbok").age(30)
                .city(cities.get(1)).build());
        listOfCitizens.add(Citizen.builder().id(uuids.get(3))
                .name("Ewa Mila").age(96)
                .city(cities.get(1)).build());
        listOfCitizens.add(Citizen.builder().id(uuids.get(4))
                .name("Andrzej Wozny").age(101)
                .city(cities.get(2)).build());
        listOfCitizens.add(Citizen.builder().id(uuids.get(5))
                .name("Micheal Jordan").age(78)
                .city(cities.get(2)).build());
        listOfCitizens.add(Citizen.builder().id(uuids.get(6))
                .name("Andrew Tata ").age(23)
                .city(cities.get(3)).build());
        return listOfCitizens;
    }

    private static List<City> loadCities() {
        List<City> listOfCities = new ArrayList<>();
        listOfCities.add(City.builder().id(UUID.fromString("e340ba5d-de57-47db-a56f-5bd788f4d183"))
                .name("Gdansk").build());

        listOfCities.add(City.builder().id(UUID.fromString("3851dc62-52b7-481a-adcd-0287c16298b5"))
                .name("Torun").build());

        listOfCities.add(City.builder().id(UUID.fromString("fd08d341-a0b4-4a32-8251-903178a6daa4"))
                .name("Gizyko").build());

        listOfCities.add(City.builder().id(UUID.fromString("df6dfefa-107d-4791-84be-f548b1a9a902"))
                .name("Krakow").build());

        return listOfCities;
    }

}
