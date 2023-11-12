package org.isa.dto.city;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class GetCitizenCityNameResponse {
    private UUID id;
    private String name;
    private int age;
    private String cityName;
}
