package org.example;

import org.example.model.Citizen;
import org.example.model.City;

import java.util.ArrayList;
import java.util.List;

public class DataLoader {
    public static void loadCompaniesToHardware(List<Citizen> listOfCitizens,
                                               List<City> listOfCompanies) {
        for (int i = 0; i < listOfCitizens.size(); i++) {
            listOfCitizens.get(i).setCity(listOfCompanies.get(i % listOfCompanies.size()));
            listOfCompanies.get(i % listOfCompanies.size()).getCitizens().add(listOfCitizens.get(i));
        }
    }

    public static List<Citizen> loadCitizens() {
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


    public static List<City> loadCities() {
        List<City> listOfCompanies = new ArrayList<>();
        listOfCompanies.add(City.builder().name("Gdansk").area(21312321).citizens(new ArrayList<>()).build());
        listOfCompanies.add(City.builder().name("Torun").area(15756657).citizens(new ArrayList<>()).build());
        listOfCompanies.add(City.builder().name("Gizyko").area(30232133).citizens(new ArrayList<>()).build());
        listOfCompanies.add(City.builder().name("Krakow").area(10123123).citizens(new ArrayList<>()).build());

        return listOfCompanies;
    }


}
