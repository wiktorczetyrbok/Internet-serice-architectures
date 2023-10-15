package org.example.utils;

import org.example.model.Citizen;
import org.example.model.City;
import org.example.service.CitizenService;
import org.example.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CliRunner implements CommandLineRunner {
    @Autowired
    private CitizenService citizenService;
    @Autowired
    private CityService cityService;


    @Override
    public void run(String... args) throws Exception {
        List<Citizen> listOfCitizens = DataLoader.loadCitizens();
        List<City> listOfCities = DataLoader.loadCities();

        DataLoader.loadCitizensToCities(listOfCitizens, listOfCities);

        listOfCities.forEach(city -> cityService.addCity(city));


        listOfCitizens.forEach(c -> citizenService.addCitizen(c));


        //     System.out.println(cityService.getAllCities());
        System.out.println(cityService.getAllCities());
        System.out.println(citizenService.getAllCitizens());
        //    System.out.println(cityService.getAllCities());
//        Task lab = new Task();
//        lab.taskTwo(listOfCities);
//        lab.taskThree(listOfCities);
//        lab.taskFour(listOfCities);
//        lab.taskFive(listOfCitizens);
//        lab.taskSix(listOfCitizens);
//        lab.taskSeven(listOfCities);


    }
}
