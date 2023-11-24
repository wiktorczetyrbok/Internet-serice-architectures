package org.isa.controller;

import lombok.RequiredArgsConstructor;
import org.isa.dto.city.GetCitizenDetailsResponse;
import org.isa.dto.city.GetCitizensResponse;
import org.isa.dto.city.PutCitizenRequest;
import org.isa.service.CitizenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/citizens")
@RequiredArgsConstructor
public class CitizenController {
    private final CitizenService citizenService;

    @PostMapping
    public ResponseEntity<Void> addNewCitizen(@RequestBody GetCitizenDetailsResponse getCitizenDetailsResponse) {
        getCitizenDetailsResponse.setId(UUID.randomUUID());
        citizenService.addCitizen(getCitizenDetailsResponse);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetCitizenDetailsResponse> getCitizenById(@PathVariable UUID id) {
        GetCitizenDetailsResponse citizen = citizenService.getCitizenById(id);
        return new ResponseEntity<>(citizen, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GetCitizenDetailsResponse> updateCitizen(
            @PathVariable UUID id,
            @RequestBody PutCitizenRequest putCitizenRequest) {
        GetCitizenDetailsResponse updatedCitizen = citizenService.updateCitizen(id, putCitizenRequest);
        return new ResponseEntity<>(updatedCitizen, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCitizen(@PathVariable UUID id) {
        citizenService.deleteCitizen(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<GetCitizensResponse> getAllCitizens() {
        GetCitizensResponse citizens = citizenService.getAllCitizens();
        return new ResponseEntity<>(citizens, HttpStatus.OK);
    }
}


