package com.yet.buchi.models.ApiModels;
import com.fasterxml.jackson.annotation.*;

public class Next {
    private String href;

    @JsonProperty("href")
    public String getHref() { return href; }
    @JsonProperty("href")
    public void setHref(String value) { this.href = value; }
}
