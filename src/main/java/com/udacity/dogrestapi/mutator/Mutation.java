package com.udacity.dogrestapi.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.udacity.dogrestapi.exception.DogNotFoundException;
import com.udacity.dogrestapi.repository.DogRepository;
import com.udacity.dogrestapi.entity.Dog;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Mutation implements GraphQLMutationResolver {
    private final DogRepository dogRepository;

    public Mutation (DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Dog updateDogName (Long id, String newName) {
        Optional<Dog> optionalDog = dogRepository.findById( id );
        if ( optionalDog.isPresent() ) {
            Dog dog = optionalDog.get();
            dog.setName( newName );
            dogRepository.save( dog );
            return dog;
        } else {
            throw new DogNotFoundException( "Dog not found ", id );
        }
    }

    public Boolean deleteDogBreed (String breed) {
        boolean deleteFlag = false;
        List<Dog> dogs = (List<Dog>) dogRepository.findAll();
        Dog dogToDelete = null;

        for ( Dog d : dogs ) {
            if ( d.getBreed().equals( breed ) ) {
                dogToDelete = d;
                break;
            }
        }

        if ( dogToDelete != null ) {
            dogRepository.delete( dogToDelete );
            deleteFlag = true;
        }

        if ( !deleteFlag ) {
            throw new DogNotFoundException( "Dog not found with that breed", null );
        }

        return deleteFlag;
    }
}
