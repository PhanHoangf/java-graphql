package com.udacity.dogrestapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Dog {
    private String Name;
    private String Breed;
    private String Origin;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Dog () {

    }

    public void setId (Long id) {
        this.id = id;
    }

    public Long getId () {
        return id;
    }

    public Dog (String name, String breed) {
        Name = name;
        Breed = breed;
    }

    public Dog (String name, String breed, String origin, Long id) {
        Name = name;
        Breed = breed;
        Origin = origin;
        this.id = id;
    }

    public String getName () {
        return Name;
    }

    public void setName (String name) {
        Name = name;
    }

    public String getBreed () {
        return Breed;
    }

    public void setBreed (String breed) {
        Breed = breed;
    }

    public String getOrigin () {
        return Origin;
    }

    public void setOrigin (String origin) {
        Origin = origin;
    }
}
