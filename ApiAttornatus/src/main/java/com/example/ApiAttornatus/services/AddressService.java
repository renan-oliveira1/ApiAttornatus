package com.example.ApiAttornatus.services;


import com.example.ApiAttornatus.core.EntityNotFoundException;
import com.example.ApiAttornatus.dto.AddressDTO;
import com.example.ApiAttornatus.entities.Address;
import com.example.ApiAttornatus.entities.People;
import com.example.ApiAttornatus.repositories.AddressRepository;
import com.example.ApiAttornatus.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {

    private AddressRepository addressRepository;
    private PeopleRepository peopleRepository;

    @Autowired
    public AddressService(
            AddressRepository addressRepository,
            PeopleRepository peopleRepository) {
        this.addressRepository = addressRepository;
        this.peopleRepository = peopleRepository;
    }


    public AddressDTO create(AddressDTO dto){
        try{
            People people = peopleRepository.findById(Long.valueOf(dto.getPeople()))
                    .orElseThrow(() -> new EntityNotFoundException("People with ID-" + dto.getPeople() +" not found!!"));
            Address address = new Address();
            copyDtoToEntity(address, dto, people);

            Address savedAddress = addressRepository.save(address);
            return new AddressDTO(savedAddress);
        }catch (Exception e){
            throw new RuntimeException("Error to create address to people!!");
        }
    }

    public List<AddressDTO> findAddressesByPeople(Long id){

        try{
            People people = peopleRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("People with ID-" + id +" not found!!"));

            List<AddressDTO> addressDTO = addressRepository.findAddressesByPeopleId(id)
                    .stream()
                    .map(it -> new AddressDTO(it))
                    .collect(Collectors.toList());

            return addressDTO;
        }catch (Exception e){
            throw new RuntimeException("Error to find addresses to people!!");
        }
    }

    public List<AddressDTO> findAddressesByPeopleIdAndMainAddressTrue(Long id){
        try{
            People people = peopleRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("People with ID-" + id +" not found!!"));

            List<AddressDTO> addressDTO = addressRepository.findAddressesByIsMainAddressAndPeopleId(true, id)
                    .stream()
                    .map(it -> new AddressDTO(it))
                    .collect(Collectors.toList());

            return addressDTO;
        }catch (Exception e){
            throw new RuntimeException("Error to find main address of people!!" + e.getMessage());
        }
    }

    private void copyDtoToEntity(Address entity, AddressDTO dto, People people){
        entity.setPeople(people);
        entity.setPlace(dto.getPlace());
        entity.setCep(dto.getCep());
        entity.setNumber(dto.getNumber());
        entity.setCity(dto.getCity());

    }



}
