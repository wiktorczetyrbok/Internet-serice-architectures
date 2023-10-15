package org.example.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
public class CitizenDto implements Serializable {
    UUID id;
    String name;
    int age;
    String cityName;
}
