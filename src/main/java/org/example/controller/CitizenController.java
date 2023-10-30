package org.example.controller;

import org.example.dto.CitizenDto;
import org.example.exception.CitizenNotFoundException;
import org.example.service.CitizenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/citizen")
public class CitizenController {
    private final CitizenService citizenService;

    public CitizenController(CitizenService citizenService) {
        this.citizenService = citizenService;
    }

    @PostMapping
    public ResponseEntity<Void> addNewCitizen(@RequestBody CitizenDto citizenDto) {
        citizenDto.setId(UUID.randomUUID());
        citizenService.addCitizen(citizenDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{name}")
    public ResponseEntity<CitizenDto> getCitizenByName(@PathVariable String name) {
        try {
            CitizenDto citizen = citizenService.getCitizenByName(name);
            return new ResponseEntity<>(citizen, HttpStatus.OK);
        } catch (CitizenNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{name}")
    public ResponseEntity<CitizenDto> updateCitizen(
            @PathVariable String name,
            @RequestBody CitizenDto updatedCitizenDto) {
        try {
            CitizenDto updatedCitizen = citizenService.updateCitizen(name, updatedCitizenDto);
            return new ResponseEntity<>(updatedCitizen, HttpStatus.OK);
        } catch (CitizenNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteCitizen(@PathVariable String name) {
        boolean deleted = citizenService.deleteCitizen(name);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<CitizenDto>> getAllCitizens() {
        List<CitizenDto> citizens = citizenService.getAllCitizens();
        return new ResponseEntity<>(citizens, HttpStatus.OK);
    }


}


