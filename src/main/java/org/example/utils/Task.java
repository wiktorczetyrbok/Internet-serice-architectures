package org.example.utils;

import org.example.dto.CitizenDto;
import org.example.mapper.CitizenMapper;
import org.example.model.Citizen;
import org.example.model.City;

import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Task {

    public void taskTwo(List<City> listOfCities) {
        listOfCities.forEach(city -> {
            System.out.print(city.getName() + ": \n");
            city.getCitizens().forEach(citizen -> {
                System.out.print(citizen.getName() + " " + citizen.getAge() + " ");
            });
        });
    }

    public void taskThree(List<City> listOfCities) {
        listOfCities.stream()
                .flatMap(city -> city.getCitizens().stream())
                .collect(Collectors.toSet()).forEach(System.out::println);
    }

    public void taskFour(List<City> listOfCities) {
        listOfCities.stream()
                .flatMap(c -> c.getCitizens().stream())
                .filter(h -> h.getAge() < 100)
                .forEach(System.out::println);
    }

    public void taskFive(List<Citizen> listOfCitizens) {
        listOfCitizens.stream()
                .map(CitizenMapper::mapToCitizenDto)
                .sorted(Comparator.comparing((CitizenDto::getName))
                        .thenComparingInt(CitizenDto::getAge))
                .forEach(System.out::println);
    }

    public void taskSix(List<Citizen> listOfCitizens) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("te.bin"));
             ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("te.bin"))) {

            objectOutputStream.writeObject(listOfCitizens);

            List<Citizen> citizenList = (List<Citizen>) objectInputStream.readObject();
            citizenList.forEach(System.out::println);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void taskSeven(List<City> listOfCities) throws InterruptedException {
        int customThreadPoolSize = 3;
        ForkJoinPool threadPool = new ForkJoinPool(customThreadPoolSize);
        try {
            threadPool.submit(() ->
                    listOfCities.parallelStream().forEach(city -> {
                        try {
                            Thread.sleep(1000);
                            System.out.println(city.getName());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
        threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
    }
}
