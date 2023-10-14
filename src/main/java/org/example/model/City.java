package org.example.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class City implements Serializable {
    String name;
    double area;
    @EqualsAndHashCode.Exclude
    List<Citizen> citizens;

    @Override
    public String toString() {
        List<String> citizensNames = citizens.stream().map(c -> c.getName()).collect(Collectors.toList());
        return "City{" +
                "name='" + name + '\'' +
                ", area=" + area +
                ", citizens=" + citizensNames +
                '}';
    }
}
