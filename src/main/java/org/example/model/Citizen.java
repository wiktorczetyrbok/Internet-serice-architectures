package org.example.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Citizen implements Serializable {
    String name;
    int age;
    City city;

    @Override
    public String toString() {
        return "Citizen{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", city=" + city.getName() +
                '}';
    }
}
