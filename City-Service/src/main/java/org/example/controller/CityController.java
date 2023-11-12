package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.GetCitiesResponse;
import org.example.dto.GetCityResponse;
import org.example.dto.PutCityRequest;
import org.example.exception.CityNotFoundException;
import org.example.service.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/cities")
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;

    @PostMapping
    public ResponseEntity<Void> addNewCity(@RequestBody GetCityResponse getCityResponse) {
        getCityResponse.setId(UUID.randomUUID());
        cityService.addCity(getCityResponse);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GetCityResponse> updateCity(
            @PathVariable UUID id,
            @RequestBody PutCityRequest putCityRequest
    ) {
        try {
            GetCityResponse updatedCity = cityService.updateCity(id, putCityRequest);
            return new ResponseEntity<>(updatedCity, HttpStatus.OK);
        } catch (CityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<GetCitiesResponse> getAllCities() {
        GetCitiesResponse cities = cityService.getAllCities();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetCityResponse> getCityById(@PathVariable UUID id) {
        try {
            GetCityResponse city = cityService.getCityById(id);
            return new ResponseEntity<>(city, HttpStatus.OK);
        } catch (CityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable UUID id) {
        boolean deleted = cityService.deleteCity(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


