package com.example.orm.controller;

import com.example.orm.entitys.Person;
import com.example.orm.repositories.hibRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/persons")
public class HipControler {

    private final hibRepo repository;

    @GetMapping("/by-city")
    public List<Person> findAll(@RequestParam String city) {
        return repository.getPersonsByCity(city);
    }
}
