package org.isa.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class GetCitizenDto {
    private UUID id;
    private String name;
    private int age;
    private String cityName;
}
