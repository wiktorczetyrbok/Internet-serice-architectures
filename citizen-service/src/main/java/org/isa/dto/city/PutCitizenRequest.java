package org.isa.dto.city;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class PutCitizenRequest {
    private String name;
    private int age;
    @JsonProperty("city_id")
    private UUID cityId;
}
