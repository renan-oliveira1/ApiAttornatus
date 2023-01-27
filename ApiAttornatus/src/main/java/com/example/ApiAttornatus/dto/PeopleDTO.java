package com.example.ApiAttornatus.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PeopleDTO {

    private Long id;
    private String name;
    private LocalDate birthDate;
    private List<AddressDTO> addresses;

}
