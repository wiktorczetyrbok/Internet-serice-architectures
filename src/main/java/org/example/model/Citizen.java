package org.example.model;

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
    UUID id;
    String name;
    int age;
    @ManyToOne
    @JoinColumn(name = "city_id")
    City city;

    @Override
    public String toString() {
        return "Citizen{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", city=" + city.getName() +
                '}';
    }
}
