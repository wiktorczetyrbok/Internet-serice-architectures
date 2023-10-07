package org.example;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class CitizenDto implements Serializable {
    String name;
    int cost;
    String cityName;
}
