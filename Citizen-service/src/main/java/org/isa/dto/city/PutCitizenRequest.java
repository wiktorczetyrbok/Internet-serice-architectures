package org.isa.dto.city;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class PutCitizenRequest {
    private String name;
    private int age;
    private UUID cityId;
}
