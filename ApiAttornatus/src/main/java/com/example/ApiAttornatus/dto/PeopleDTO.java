package com.example.ApiAttornatus.dto;

import com.example.ApiAttornatus.entities.People;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class PeopleDTO {

    private Long id;
    private String name;
    private LocalDate birthDate;
    private List<AddressDTO> addresses = new ArrayList<>();

    public PeopleDTO() {
    }

    public PeopleDTO(Long id, String name, LocalDate birthDate, List<AddressDTO> addresses) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.addresses = addresses;
    }

    public PeopleDTO(People people) {
        this.id = people.getId();
        this.name = people.getName();
        this.birthDate = people.getBirthDate();
        people.getAddress().forEach(address -> this.addresses.add(new AddressDTO(address)));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<AddressDTO> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressDTO> addresses) {
        this.addresses = addresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PeopleDTO peopleDTO = (PeopleDTO) o;
        return Objects.equals(id, peopleDTO.id) && name.equals(peopleDTO.name) && birthDate.equals(peopleDTO.birthDate) && Objects.equals(addresses, peopleDTO.addresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthDate, addresses);
    }
}
