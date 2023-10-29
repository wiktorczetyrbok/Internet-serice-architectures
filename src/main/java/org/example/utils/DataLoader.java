package org.example.utils;

import jakarta.annotation.PostConstruct;
import org.example.model.Citizen;
import org.example.model.City;
import org.example.repository.CitizenRepository;
import org.example.repository.CityRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader {

    private final CityRepository cityRepository;

    private final CitizenRepository citizenRepository;

    public DataLoader(CityRepository cityRepository, CitizenRepository citizenRepository) {
        this.cityRepository = cityRepository;
        this.citizenRepository = citizenRepository;
    }

    @PostConstruct
    public void persistData() {
        List<Citizen> listOfCitizens = DataLoader.loadCitizens();
        List<City> listOfCities = DataLoader.loadCities();

        loadCitizensToCities(listOfCitizens, listOfCities);

        listOfCities.forEach(city -> cityRepository.save(city));
        listOfCitizens.forEach(c -> citizenRepository.save(c));
    }

    private static void loadCitizensToCities(List<Citizen> listOfCitizens,
                                             List<City> listOfCities) {
        for (int i = 0; i < listOfCitizens.size(); i++) {
            listOfCitizens.get(i).setCity(listOfCities.get(i % listOfCities.size()));
            listOfCities.get(i % listOfCities.size()).getCitizens().add(listOfCitizens.get(i));
        }
    }

    private static List<Citizen> loadCitizens() {
        List<Citizen> listOfCitizens = new ArrayList<>();
        listOfCitizens.add(Citizen.builder().name("Jeff Eng").age(24).city(null).build());
        listOfCitizens.add(Citizen.builder().name("Senthil gopsalym").age(120).city(null).build());
        listOfCitizens.add(Citizen.builder().name("Wiktor Czetyrbok").age(30).city(null).build());
        listOfCitizens.add(Citizen.builder().name("Ewa Mila").age(96).city(null).build());
        listOfCitizens.add(Citizen.builder().name("Andrzej Wozny").age(101).city(null).build());
        listOfCitizens.add(Citizen.builder().name("Micheal Jordan").age(78).city(null).build());
        listOfCitizens.add(Citizen.builder().name("Andrew Tata ").age(23).city(null).build());
        return listOfCitizens;
    }


    private static List<City> loadCities() {
        List<City> listOfCities = new ArrayList<>();
        listOfCities.add(City.builder().name("Gdansk").area(21312321).citizens(new ArrayList<>()).build());
        listOfCities.add(City.builder().name("Torun").area(15756657).citizens(new ArrayList<>()).build());
        listOfCities.add(City.builder().name("Gizyko").area(30232133).citizens(new ArrayList<>()).build());
        listOfCities.add(City.builder().name("Krakow").area(10123123).citizens(new ArrayList<>()).build());
        return listOfCities;
    }
}
