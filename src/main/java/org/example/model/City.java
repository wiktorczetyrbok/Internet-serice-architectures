package org.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cities")
public class City implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    String name;
    double area;
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Citizen> citizens;


    @Override
    public String toString() {
        List<String> citizensNames = citizens.stream().map(c -> c.getName()).collect(Collectors.toList());
        return "City{" +
                "id=" + id +
                "name='" + name + '\'' +
                ", area=" + area +
                ", citizens=" + citizensNames +
                '}';
    }
}
