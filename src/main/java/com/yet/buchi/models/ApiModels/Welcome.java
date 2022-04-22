package com.yet.buchi.models.ApiModels;
import com.fasterxml.jackson.annotation.*;

public class Welcome {
    private Animal[] animals;
    private Pagination pagination;

    @JsonProperty("animals")
    public Animal[] getAnimals() { return animals; }
    @JsonProperty("animals")
    public void setAnimals(Animal[] value) { this.animals = value; }

    @JsonProperty("pagination")
    public Pagination getPagination() { return pagination; }
    @JsonProperty("pagination")
    public void setPagination(Pagination value) { this.pagination = value; }
}
