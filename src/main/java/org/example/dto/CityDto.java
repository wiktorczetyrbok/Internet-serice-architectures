package org.example.dto;

import lombok.Builder;
import lombok.Data;
import org.example.model.Citizen;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class CityDto {
    private UUID id;
    private String name;
    private double area;
    private List<Citizen> citizens;

    public List<Citizen> getCitizens() {
        return citizens == null ? new ArrayList<>() : citizens;
    }
}
