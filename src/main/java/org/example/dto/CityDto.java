package org.example.dto;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class CityDto {
    private UUID id;
    private String name;
    private double area;
    private List<UUID> citizensID;

    public List<UUID> getCitizens() {
        return citizensID == null ? new ArrayList<>() : citizensID;
    }
}
