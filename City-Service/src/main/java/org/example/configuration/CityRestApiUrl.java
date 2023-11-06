package org.example.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
@Getter
public class CityRestApiUrl {
    @Value("${isa.city.url.delete}")
    private String deleteUrl;
    @Value("${isa.city.url.put}")
    private String putUrl;
    @Value("${isa.city.url.post}")
    private String postUrl;
}
