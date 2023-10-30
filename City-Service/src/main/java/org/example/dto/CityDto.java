package org.example.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class CityDto {
    private UUID id;
    private String name;
    private double area;
    private List<UUID> citizensIds;
}
