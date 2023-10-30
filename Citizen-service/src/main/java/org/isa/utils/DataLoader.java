package org.isa.utils;

import jakarta.annotation.PostConstruct;
import org.isa.model.Citizen;
import org.isa.repository.CitizenRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Component
public class DataLoader {


    private final CitizenRepository citizenRepository;

    public DataLoader(CitizenRepository citizenRepository) {
        this.citizenRepository = citizenRepository;
    }

    @PostConstruct
    public void persistData() {
        List<Citizen> listOfCitizens = DataLoader.loadCitizens();
        citizenRepository.saveAll(listOfCitizens);
    }


    private static List<Citizen> loadCitizens() {
        List<Citizen> listOfCitizens = new ArrayList<>();
        List<UUID> uuids = Arrays.asList(
                UUID.fromString("aa2b6af2-3c14-4784-b524-110798769d72"),
                UUID.fromString("1c2b8bdb-f83f-4594-a18b-4073ec5b5afb"),
                UUID.fromString("055555d6-1cd0-4268-a519-176381ed2799"),
                UUID.fromString("8b0454ff-e4f7-4d4d-ae16-4c84162a1c5a"),
                UUID.fromString("445cfb56-ca51-4da3-b244-dfc108460981"),
                UUID.fromString("04dbe36d-e6ca-4030-a3e9-b202967de4cd"),
                UUID.fromString("9d1d3e0a-bb79-4de4-a836-87ca02216846")

        );
        listOfCitizens.add(Citizen.builder().id(uuids.get(0))
                .name("Jeff Eng").age(24)
                .cityId(UUID.fromString("e340ba5d-de57-47db-a56f-5bd788f4d183")).build());
        listOfCitizens.add(Citizen.builder().id(uuids.get(1))
                .name("Senthil gopsalym").age(120)
                .cityId(UUID.fromString("e340ba5d-de57-47db-a56f-5bd788f4d183")).build());
        listOfCitizens.add(Citizen.builder().id(uuids.get(2))
                .name("Wiktor Czetyrbok").age(30)
                .cityId(UUID.fromString("3851dc62-52b7-481a-adcd-0287c16298b5")).build());
        listOfCitizens.add(Citizen.builder().id(uuids.get(3))
                .name("Ewa Mila").age(96)
                .cityId(UUID.fromString("3851dc62-52b7-481a-adcd-0287c16298b5")).build());
        listOfCitizens.add(Citizen.builder().id(uuids.get(4))
                .name("Andrzej Wozny").age(101)
                .cityId(UUID.fromString("fd08d341-a0b4-4a32-8251-903178a6daa4")).build());
        listOfCitizens.add(Citizen.builder().id(uuids.get(5))
                .name("Micheal Jordan").age(78)
                .cityId(UUID.fromString("fd08d341-a0b4-4a32-8251-903178a6daa4")).build());
        listOfCitizens.add(Citizen.builder().id(uuids.get(6))
                .name("Andrew Tata ").age(23)
                .cityId(UUID.fromString("df6dfefa-107d-4791-84be-f548b1a9a902")).build());
        return listOfCitizens;
    }

}
