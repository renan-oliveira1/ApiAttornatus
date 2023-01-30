package com.example.ApiAttornatus.controller;

import com.example.ApiAttornatus.dto.MessageResponseDTO;
import com.example.ApiAttornatus.dto.PeopleDTO;
import com.example.ApiAttornatus.entities.People;
import com.example.ApiAttornatus.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/people")
public class PeopleController {

    private PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PeopleDTO create(@RequestBody People people){
        return peopleService.create(people);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PeopleDTO> findAll(){
        return peopleService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PeopleDTO findOne(@PathVariable Long id){
        return peopleService.findOne(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public PeopleDTO update(@RequestBody People people){return peopleService.update(people.getId(), people);}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO delete(@PathVariable Long id){return  peopleService.delete(id);}
}
