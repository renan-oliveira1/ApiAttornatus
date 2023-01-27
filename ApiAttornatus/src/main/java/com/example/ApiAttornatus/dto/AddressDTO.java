package com.example.ApiAttornatus.dto;

import com.example.ApiAttornatus.entities.People;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    private Long id;

    private String place;

    private String cep;

    private String number;

    private String city;

    private boolean isMainAddress;

}
