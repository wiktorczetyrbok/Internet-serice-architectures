package org.example.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PutCityRequest {
    private String name;
    private double area;
}
