package com.udacity.dogrestapi.service;

import com.udacity.dogrestapi.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.udacity.dogrestapi.entity.Dog;

@Service
public class DogServiceImpl implements DogService {
    @Autowired
    DogRepository dogRepository;

    @Override
    public List<String> getDogBreed () {
        List<Dog> Dogs = (List<Dog>) dogRepository.findAll();
        return Dogs.stream().map( Dog::getBreed ).toList();
    }

    @Override
    public String retrieveDogBreedById (Long id) {
        Optional<Dog> dog = dogRepository.findById( id );
        return dog.map( Dog::getBreed ).orElse( null );
    }

    @Override
    public List<String> retrieveDogNames () {
        List<Dog> Dogs = (List<Dog>) dogRepository.findAll();
        return Dogs.stream().map( Dog::getName ).toList();
    }
}
