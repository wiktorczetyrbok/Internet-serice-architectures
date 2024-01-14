package org.isa.dto.city;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.isa.dto.citizen.GetCityResponse;

import java.util.UUID;

@Data
@Builder
public class GetCitizenDetailsResponse {
    private UUID id;
    private String name;
    private int age;
    @JsonProperty("city")
    private GetCityResponse city;
}
