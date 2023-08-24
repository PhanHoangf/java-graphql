package com.udacity.dogrestapi.service;

import java.util.List;

public interface DogService {
    public List<String> getDogBreed ();

    public String retrieveDogBreedById (Long id);

    public List<String> retrieveDogNames ();
}
