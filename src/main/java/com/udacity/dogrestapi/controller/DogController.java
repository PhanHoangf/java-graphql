package com.udacity.dogrestapi.controller;

import com.udacity.dogrestapi.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DogController {
    private DogService dogService;

    @Autowired
    public void setDogService (DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/dogs")
    public ResponseEntity<List<String>> getDogsName () {
        List<String> dogNames = dogService.retrieveDogNames();
        List<String> test = new ArrayList<>();
        test.add( "ABC" );
        return new ResponseEntity<>( dogNames, HttpStatus.OK );
    }
}
