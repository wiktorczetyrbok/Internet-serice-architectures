package org.isa.dto.citizen;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class GetCityResponse {
    private UUID id;
    private String name;
}
