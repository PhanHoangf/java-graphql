package com.udacity.dogrestapi.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udacity.dogrestapi.exception.DogNotFoundException;
import com.udacity.dogrestapi.repository.DogRepository;
import com.udacity.dogrestapi.entity.Dog;

import java.util.List;
import java.util.Optional;

public class Query implements GraphQLQueryResolver {
    private final DogRepository dogRepository;

    public Query (DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Iterable<Dog> findAllDogs () {
        return dogRepository.findAll();
    }

    public Iterable<String> findAllDogsName () {
        List<Dog> dogs = (List<Dog>) dogRepository.findAll();
        return dogs.stream().map( Dog::getName ).toList();
    }

    public Iterable<String> findDogBreeds () {
        List<Dog> dogs = (List<Dog>) dogRepository.findAll();
        return dogs.stream().map( Dog::getBreed ).toList();
    }

    public String findDogBreedById (Long id) {
        Optional<Dog> dog = dogRepository.findById( id );
        if ( dog.isPresent() ) {
            return dog.get().getBreed();
        } else {
            throw new DogNotFoundException( "Dog cannot find with id ", id );
        }
    }

    public Dog findDogById (Long id) {
        Optional<Dog> dog = dogRepository.findById( id );
        if ( dog.isPresent() ) {
            return dog.get();
        } else {
            throw new DogNotFoundException( "Dog cannot find with id ", id );
        }
    }

}
