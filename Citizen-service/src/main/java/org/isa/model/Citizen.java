package org.isa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
@Entity
@Table(name = "citizens")
@AllArgsConstructor
@NoArgsConstructor
public class Citizen implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private int age;
    @Column(name = "city_id")
    private UUID cityId;
}
