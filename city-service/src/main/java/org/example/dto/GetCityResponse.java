package org.example.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class GetCityResponse {
    private UUID id;
    private String name;
    private double area;
}
