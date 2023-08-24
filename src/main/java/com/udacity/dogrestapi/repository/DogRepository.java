package com.udacity.dogrestapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.udacity.dogrestapi.entity.Dog;


public interface DogRepository extends CrudRepository<Dog, Long> {
}