package org.isa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CitizenApp {

    public static void main(String[] args) {
        SpringApplication.run(CitizenApp.class, args);
    }

}
