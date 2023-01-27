package com.example.ApiAttornatus.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String place;

    private String cep;

    private String number;

    private String city;

    private boolean isMainAddress;

    @ManyToOne
    @JoinColumn(name = "people_id")
    private People people;

}
