package org.isa.dto.city;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Data
@Builder
public class GetCitizensResponse {

    @Singular
    private List<GetCitizenResponse> citizens;

}
