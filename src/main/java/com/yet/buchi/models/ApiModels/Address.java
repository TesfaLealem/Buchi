package com.yet.buchi.models.ApiModels;

import com.fasterxml.jackson.annotation.*;



public class Address {
    private Object address1;
    private Object address2;
    private City city;
    private State state;
    private String postcode;
    private Country country;

    @JsonProperty("address1")
    public Object getAddress1() { return address1; }
    @JsonProperty("address1")
    public void setAddress1(Object value) { this.address1 = value; }

    @JsonProperty("address2")
    public Object getAddress2() { return address2; }
    @JsonProperty("address2")
    public void setAddress2(Object value) { this.address2 = value; }

    @JsonProperty("city")
    public City getCity() { return city; }
    @JsonProperty("city")
    public void setCity(City value) { this.city = value; }

    @JsonProperty("state")
    public State getState() { return state; }
    @JsonProperty("state")
    public void setState(State value) { this.state = value; }

    @JsonProperty("postcode")
    public String getPostcode() { return postcode; }
    @JsonProperty("postcode")
    public void setPostcode(String value) { this.postcode = value; }

    @JsonProperty("country")
    public Country getCountry() { return country; }
    @JsonProperty("country")
    public void setCountry(Country value) { this.country = value; }
}
