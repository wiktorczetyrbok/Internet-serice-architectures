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
    UUID id;
    String name;
    double area;
    List<Citizen> citizens;

    public List<Citizen> getCitizens() {
        return citizens == null ? new ArrayList<>() : citizens;
    }
}
