package org.example;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder

public class Citizen implements Serializable {
    String name;
    int age;
    City city;
}
