package com.yet.buchi.models.ApiModels;
import com.fasterxml.jackson.annotation.*;

public class AnimalLinks {
    private Next self;
    private Next type;
    private Next organization;

    @JsonProperty("self")
    public Next getSelf() { return self; }
    @JsonProperty("self")
    public void setSelf(Next value) { this.self = value; }

    @JsonProperty("type")
    public Next getType() { return type; }
    @JsonProperty("type")
    public void setType(Next value) { this.type = value; }

    @JsonProperty("organization")
    public Next getOrganization() { return organization; }
    @JsonProperty("organization")
    public void setOrganization(Next value) { this.organization = value; }
}
