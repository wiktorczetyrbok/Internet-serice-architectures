package org.example;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class City implements Serializable {
    String name;
    double area;
    @EqualsAndHashCode.Exclude
    List<Citizen> citizens;
}
