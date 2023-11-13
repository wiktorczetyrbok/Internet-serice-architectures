package org.isa.controller;

import lombok.RequiredArgsConstructor;
import org.isa.dto.citizen.GetCityResponse;
import org.isa.dto.citizen.PutCityRequest;
import org.isa.exception.CityNotFoundException;
import org.isa.service.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/cities")
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;

    @PostMapping
    public ResponseEntity<Void> addNewCity(@RequestBody GetCityResponse getCityResponse) {
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
    public ResponseEntity<List<GetCityResponse>> getAllCities() {
        List<GetCityResponse> cities = cityService.getAllCities();
        return new ResponseEntity<>(cities, HttpStatus.OK);
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


