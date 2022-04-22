package com.yet.buchi.models.ApiModels;
import com.fasterxml.jackson.annotation.*;

public class PaginationLinks {
    private Next next;

    @JsonProperty("next")
    public Next getNext() { return next; }
    @JsonProperty("next")
    public void setNext(Next value) { this.next = value; }
}
