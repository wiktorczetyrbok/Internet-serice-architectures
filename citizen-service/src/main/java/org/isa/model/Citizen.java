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
    @Column(unique = true)
    private UUID id;
    private String name;
    private int age;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

}
