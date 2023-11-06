package org.isa.controller;

import org.isa.dto.CitizenDto;
import org.isa.dto.GetCitizenDto;
import org.isa.exception.CitizenNotFoundException;
import org.isa.exception.CityNotFoundException;
import org.isa.service.CitizenService;
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
        try {
            citizenService.addCitizen(citizenDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (CityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @GetMapping("/{name}")
    public ResponseEntity<GetCitizenDto> getCitizenByName(@PathVariable String name) {
        try {
            GetCitizenDto citizen = citizenService.getCitizenByName(name);
            return new ResponseEntity<>(citizen, HttpStatus.OK);
        } catch (CitizenNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CitizenDto> updateCitizen(
            @PathVariable UUID id,
            @RequestBody CitizenDto updatedCitizenDto) {
        try {
            CitizenDto updatedCitizen = citizenService.updateCitizen(id, updatedCitizenDto);
            return new ResponseEntity<>(updatedCitizen, HttpStatus.OK);
        } catch (CitizenNotFoundException | CityNotFoundException e
        ) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCitizen(@PathVariable UUID id) {
        boolean deleted = citizenService.deleteCitizen(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<GetCitizenDto>> getAllCitizens() {
        List<GetCitizenDto> citizens = citizenService.getAllCitizens();
        return new ResponseEntity<>(citizens, HttpStatus.OK);
    }
}


