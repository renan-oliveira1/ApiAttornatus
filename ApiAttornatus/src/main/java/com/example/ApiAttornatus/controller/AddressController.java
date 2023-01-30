package com.example.ApiAttornatus.controller;

import com.example.ApiAttornatus.dto.AddressDTO;
import com.example.ApiAttornatus.entities.Address;
import com.example.ApiAttornatus.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/address")
public class AddressController {

    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AddressDTO create(@RequestBody AddressDTO dto){
        return addressService.create(dto);
    }

    @GetMapping("/people/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<AddressDTO> findAddressesByPeople(@PathVariable Long id){ return addressService.findAddressesByPeople(id);}

    @GetMapping("/main/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<AddressDTO> findMainAddreessByPeople(@PathVariable Long id){ return addressService.findAddressesByPeopleIdAndMainAddressTrue(id);}

}
