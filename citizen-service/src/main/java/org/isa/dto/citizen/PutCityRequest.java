package org.isa.dto.citizen;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PutCityRequest {
    private String name;
}
