package org.example;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
public class City implements Serializable {
    String name;
    double area;
    @EqualsAndHashCode.Exclude
    List<Citizen> citizens;
}
