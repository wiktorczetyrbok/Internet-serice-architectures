package org.example.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Data
@Builder
public class GetCitiesResponse {
    @Singular
    private List<GetCityResponse> cities;
}
