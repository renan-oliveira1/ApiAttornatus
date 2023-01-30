package com.example.ApiAttornatus.services;

import com.example.ApiAttornatus.core.EntityNotFoundException;
import com.example.ApiAttornatus.dto.MessageResponseDTO;
import com.example.ApiAttornatus.dto.PeopleDTO;
import com.example.ApiAttornatus.entities.Address;
import com.example.ApiAttornatus.entities.People;
import com.example.ApiAttornatus.repositories.AddressRepository;
import com.example.ApiAttornatus.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PeopleService {

    private PeopleRepository peopleRepository;
    private AddressRepository addressRepository;

    @Autowired
    public PeopleService(
            PeopleRepository peopleRepository,
            AddressRepository addressRepository) {
        this.peopleRepository = peopleRepository;
        this.addressRepository = addressRepository;
    }

    public PeopleDTO create(People people){
        try{
            People savedPeople =  peopleRepository.save(people);

            if (people.getAddress().size() > 0){
                for (Address address : people.getAddress()){
                    address.setPeople(savedPeople);
                    addressRepository.save(address);
                }
            }

            return new PeopleDTO(savedPeople);
        }catch (Exception e){
            throw new RuntimeException("Error to create people!!" + e.getMessage());
        }

    }

    public List<PeopleDTO> findAll(){
        List<People> peoples = peopleRepository.findAll();


        return peoples.stream().map(x -> new PeopleDTO(x)).collect(Collectors.toList());
    }

    public PeopleDTO findOne(Long id){
        People peopleExists = peopleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("People with ID-" + id +" not found!!"));
        return new PeopleDTO(peopleExists);
    }

    public PeopleDTO update(Long id, People people){
        try{
            People peopleExists = peopleRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("People with ID-" + id +" not found!!"));

            People updatedPeople = peopleRepository.save(people);
            return new PeopleDTO(updatedPeople);
        }catch (Exception e){
            throw new RuntimeException("Error to update people!!");
        }

    }

    public MessageResponseDTO delete(Long id){
        try{
            People peopleExists = peopleRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("People with ID-" + id +" not found!!"));

            peopleRepository.delete(peopleExists);
            return new MessageResponseDTO("People with ID-" + id +" deleted!!");
        }catch (Exception e){
            throw new RuntimeException("Error to delete people!!");
        }
    }



}
