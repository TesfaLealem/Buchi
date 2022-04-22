package com.yet.buchi.models.ApiModels;
import com.fasterxml.jackson.annotation.*;

public class Environment {
    private Boolean children;
    private Boolean dogs;
    private Boolean cats;

    @JsonProperty("children")
    public Boolean getChildren() { return children; }
    @JsonProperty("children")
    public void setChildren(Boolean value) { this.children = value; }

    @JsonProperty("dogs")
    public Boolean getDogs() { return dogs; }
    @JsonProperty("dogs")
    public void setDogs(Boolean value) { this.dogs = value; }

    @JsonProperty("cats")
    public Boolean getCats() { return cats; }
    @JsonProperty("cats")
    public void setCats(Boolean value) { this.cats = value; }
}
