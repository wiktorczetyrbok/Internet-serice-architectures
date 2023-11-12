package org.isa.dto.city;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class GetCitizenCityNameResponse {
    private UUID id;
    private String name;
    private int age;
    @JsonProperty("city_name")
    private String cityName;
}
