package org.example;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Builder
public class CitizenDto implements Serializable {
    String name;
    int cost;
    String cityName;
}
