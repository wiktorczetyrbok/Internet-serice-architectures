package org.example;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Comparator;

@Getter
@Setter
@Builder

public class Citizen implements Comparable<Citizen>, Serializable {
    String name;
    int age;
    City city;

    @Override
    public int compareTo(Citizen otherCitizen) {
        return Comparator.comparing(Citizen::getName)
                .thenComparingInt(Citizen::getAge)
                .compare(this, otherCitizen);
    }
}
