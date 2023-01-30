package com.example.ApiAttornatus.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String place;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private String city;

    @Column()
    private boolean isMainAddress;

    @ManyToOne
    @JoinColumn(name = "people_id")
    private People people;

    public Address() {
    }

    public Address(Long id, String place, String cep, String number, String city, boolean isMainAddress) {
        this.id = id;
        this.place = place;
        this.cep = cep;
        this.number = number;
        this.city = city;
        this.isMainAddress = isMainAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isMainAddress() {
        return isMainAddress;
    }

    public void setMainAddress(boolean mainAddress) {
        isMainAddress = mainAddress;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return isMainAddress == address.isMainAddress && Objects.equals(id, address.id) && place.equals(address.place) && cep.equals(address.cep) && number.equals(address.number) && city.equals(address.city) && people.equals(address.people);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, place, cep, number, city, isMainAddress, people);
    }
}
