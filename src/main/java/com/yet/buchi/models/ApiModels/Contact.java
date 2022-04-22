package com.yet.buchi.models.ApiModels;
import com.fasterxml.jackson.annotation.*;

public class Contact {
    private Email email;
    private Phone phone;
    private Address address;

    @JsonProperty("email")
    public Email getEmail() { return email; }
    @JsonProperty("email")
    public void setEmail(Email value) { this.email = value; }

    @JsonProperty("phone")
    public Phone getPhone() { return phone; }
    @JsonProperty("phone")
    public void setPhone(Phone value) { this.phone = value; }

    @JsonProperty("address")
    public Address getAddress() { return address; }
    @JsonProperty("address")
    public void setAddress(Address value) { this.address = value; }
}
