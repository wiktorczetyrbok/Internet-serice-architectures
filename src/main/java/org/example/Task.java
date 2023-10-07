package org.example;

import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Task {

    public void taskTwo(List<City> listOfCities) {
        listOfCities.forEach(company -> {
            System.out.print(company.getName() + ": \n");
            company.getCitizens().forEach(hardware -> {
                System.out.print(hardware.getName() + " " + hardware.getAge() + " ");
            });
        });
    }

    public void taskThree(List<City> listOfCities) {
        listOfCities.stream()
                .flatMap(company -> company.getCitizens().stream())
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
                .map(Mapper::mapToCitizenDto)
                .sorted(Comparator.comparing(CitizenDto::getName).reversed()
                        .thenComparingInt(CitizenDto::getCost).reversed())
                .forEach(System.out::println);
    }

    public void taskSix(List<Citizen> listOfCitizens) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("te.bin"));
             ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("te.bin"))) {

            objectOutputStream.writeObject(listOfCitizens);

            List<Citizen> hdlist = (List<Citizen>) objectInputStream.readObject();
            hdlist.forEach(System.out::println);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void taskSeven(List<City> listOfCities) throws InterruptedException {
        int customThreadPoolSize = 3;
        ForkJoinPool threadPool = new ForkJoinPool(customThreadPoolSize);
        try {
            threadPool.submit(() ->
                    listOfCities.parallelStream().forEach(company -> {
                        try {
                            Thread.sleep(1000);
                            System.out.println(company.getName());
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
