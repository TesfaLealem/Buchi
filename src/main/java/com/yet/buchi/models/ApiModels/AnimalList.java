package com.yet.buchi.models.ApiModels;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class AnimalList {
    private List<Animal> animals;

    public AnimalList() {
        animals = new ArrayList<>();
    }
}
