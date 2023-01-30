package com.example.ApiAttornatus.dto;

import com.example.ApiAttornatus.entities.Address;
import com.example.ApiAttornatus.entities.People;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



public class AddressDTO {

    private Long id;

    private String place;

    private String cep;

    private String number;

    private String city;

    private boolean isMainAddress;

    private String people;

    public AddressDTO() {
    }

    public AddressDTO(Long id, String place, String cep, String number, String city, boolean isMainAddress, String people) {
        this.id = id;
        this.place = place;
        this.cep = cep;
        this.number = number;
        this.city = city;
        this.isMainAddress = isMainAddress;
        this.people = people;
    }

    public AddressDTO(String place, String cep, String number, String city, String people) {
        this.place = place;
        this.cep = cep;
        this.number = number;
        this.city = city;
        this.people = people;
    }

    public AddressDTO(Address addressEntity) {
        this.id = addressEntity.getId();
        this.place = addressEntity.getPlace();
        this.cep = addressEntity.getCep();
        this.number = addressEntity.getNumber();
        this.city = addressEntity.getCity();
        this.isMainAddress = addressEntity.isMainAddress();
        this.people = String.valueOf(addressEntity.getPeople().getId());
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

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }
}
