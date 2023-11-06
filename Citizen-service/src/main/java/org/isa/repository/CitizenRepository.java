package org.isa.repository;


import org.isa.model.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CitizenRepository extends JpaRepository<Citizen, UUID> {
    @Override
    List<Citizen> findAll();

    @Query("select c from Citizen c where c.name = :name and c.age = :age")
    Optional<Citizen> findCitizenByNameAndAge(
            @Param("name") String name,
            @Param("age") int age);

    Optional<Citizen> findByName(String name);
}
