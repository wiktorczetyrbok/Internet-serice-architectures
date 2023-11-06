package org.isa.controller;

import org.isa.dto.CityDto;
import org.isa.exception.CityNotFoundException;
import org.isa.service.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/city")
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping
    public ResponseEntity<Void> addNewCity(@RequestBody CityDto cityDto) {
        cityService.addCity(cityDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CityDto> updateCity(
            @PathVariable UUID id,
            @RequestBody CityDto updatedCityDto
    ) {
        try {
            CityDto updatedCity = cityService.updateCity(id, updatedCityDto);
            return new ResponseEntity<>(updatedCity, HttpStatus.OK);
        } catch (CityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<CityDto>> getAllCities() {
        List<CityDto> cities = cityService.getAllCities();
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


