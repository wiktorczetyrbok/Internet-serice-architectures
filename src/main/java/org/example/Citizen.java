package org.example;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Builder

public class Citizen implements Serializable {
    String name;
    int age;
    City city;
}
