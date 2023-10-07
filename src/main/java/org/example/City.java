package org.example;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

@Getter
@Setter
@Builder
public class City implements Comparable<City>, Serializable {
    String name;
    double area;
    @EqualsAndHashCode.Exclude
    List<Citizen> citizens;

    @Override
    public int compareTo(City otherCompany) {
        return Comparator.comparing(City::getName)
                .thenComparingDouble(City::getArea)
                .compare(this, otherCompany);
    }
}
