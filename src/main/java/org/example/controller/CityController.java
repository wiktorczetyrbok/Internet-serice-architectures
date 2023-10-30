package org.example.controller;

import org.example.dto.CityDto;
import org.example.exception.CityNotFoundException;
import org.example.service.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<CityDto>> getAllCities() {
        List<CityDto> cities = cityService.getAllCities();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<CityDto> getCity(@PathVariable String name) {
        try {
            CityDto city = cityService.getCityByName(name);
            return new ResponseEntity<>(city, HttpStatus.OK);
        } catch (CityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteCity(@PathVariable String name) {
        boolean deleted = cityService.deleteCity(name);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


