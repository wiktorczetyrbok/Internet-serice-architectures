package org.example.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class CitizenDto implements Serializable {
    String name;
    int cost;
    String cityName;
}
