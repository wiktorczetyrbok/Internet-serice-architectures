package org.example.utils;

import org.example.dto.CitizenDto;
import org.example.dto.CityDto;
import org.example.model.Citizen;
import org.example.model.City;
import org.example.service.CitizenService;
import org.example.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

@Component
public class CliRunner implements CommandLineRunner {
    @Autowired
    private CitizenService citizenService;
    @Autowired
    private CityService cityService;
    @Autowired
    private ConfigurableApplicationContext context;


    @Transactional
    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            showMenu();
            int command = scanner.nextInt();
            switch (command) {
                case 1:
                    showCommands();
                    break;
                case 2:
                    listCities();
                    break;
                case 3:
                    listCitizens();
                    break;
                case 4:
                    addNewCitizen();
                    break;
                case 5:
                    deleteExistingCitizen();
                    break;
                case 6:
                    System.exit(SpringApplication.exit(context));
                default:
                    System.out.println("Invalid command.");

            }
        }

    }

    @Transactional
    public void deleteExistingCitizen() {
        Scanner scanner = new Scanner(System.in);

        City city = null;
        while (city == null) {

            System.out.println("Coompany name of the citizen you want to delete:");
            String cityName = scanner.next();
            city = cityService.getCityByName(cityName);
            if (city == null) {
                System.out.println("Invalid City. Try again.");
            }
        }

        List<Citizen> citizenList = city.getCitizens();
        if (citizenList.isEmpty()) {
            System.out.println("No citizen in this category.");
            return;
        }

        System.out.println(city.getName() + ":");
        for (int i = 0; i < citizenList.size(); i++) {
            Citizen citizen = citizenList.get(i);
            System.out.println((i + 1) + ". " + citizen.getName() + " (ID: " + citizen.getId() + ")");
        }

        System.out.println("Index of the citizen:");
        int citizenIndex = scanner.nextInt();
        Citizen selectedCitizen = citizenList.get(citizenIndex - 1);
        citizenService.deleteCitizen(selectedCitizen);
        System.out.println("Citizen deleted.");


    }

    private void listCitizens() {
        List<CitizenDto> citizenList = citizenService.getAllCitizens();
        if (citizenList.isEmpty()) {
            System.out.println("There are no citizens.");
        } else {
            int index = 1;
            for (CitizenDto citizen : citizenList) {
                System.out.println(index + "." + citizen);
                index++;
            }
        }

    }

    @Transactional
    public void addNewCitizen() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Citizen name: ");
        String name = scanner.next();

        System.out.println("Citizen age: ");
        int age = scanner.nextInt();
        City city = null;
        while (city == null) {
            System.out.println("City name for the citizen: ");
            String cityName = scanner.next();
            city = cityService.getCityByName(cityName);
            if (city == null) {
                System.out.println("City not found. Try again.");
            }
        }

        Citizen citizen = Citizen.builder()
                .id(UUID.randomUUID())
                .name(name)
                .age(age)
                .city(city)
                .build();

        citizenService.addCitizen(citizen);
        System.out.println("Added new citizen.");
    }

    private void listCities() {
        List<CityDto> cityList = cityService.getAllCities();
        if (cityList.isEmpty()) {
            System.out.println("There are no cities.");
        }
        int index = 1;
        for (CityDto city : cityList) {
            System.out.println(index + "." + city);
            index++;
        }
    }

    private void showCommands() {
        System.out.println("All Available Commands");
        System.out.println("1 - List available commands");
        System.out.println("2 - List all cities");
        System.out.println("3 - List all citizens");
        System.out.println("4 - Add new Citizen");
        System.out.println("5 - Delete existing citizen");
        System.out.println("6 - Stop the application");
    }

    public void showMenu() {
        System.out.println("Menu:");
        System.out.println("1.List available commands");
        System.out.println("2.List all cities");
        System.out.println("3.List all citizens");
        System.out.println("4.Add new Citizen");
        System.out.println("5.Delete existing citizen");
        System.out.println("6.Stop the application");
        System.out.print("Enter a command: ");
    }
}


