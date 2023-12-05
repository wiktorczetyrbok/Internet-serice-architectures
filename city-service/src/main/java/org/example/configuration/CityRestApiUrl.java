package org.example.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
@Getter
public class CityRestApiUrl {
    @Value("${isa.citizen-service.url.delete}")
    private String deleteUrl;
    @Value("${isa.citizen-service.url.put}")
    private String putUrl;
    @Value("${isa.citizen-service.url.post}")
    private String postUrl;
}
