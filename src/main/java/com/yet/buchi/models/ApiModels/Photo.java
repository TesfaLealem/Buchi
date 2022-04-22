package com.yet.buchi.models.ApiModels;
import com.fasterxml.jackson.annotation.*;

public class Photo {
    private String small;
    private String medium;
    private String large;
    private String full;

    @JsonProperty("small")
    public String getSmall() { return small; }
    @JsonProperty("small")
    public void setSmall(String value) { this.small = value; }

    @JsonProperty("medium")
    public String getMedium() { return medium; }
    @JsonProperty("medium")
    public void setMedium(String value) { this.medium = value; }

    @JsonProperty("large")
    public String getLarge() { return large; }
    @JsonProperty("large")
    public void setLarge(String value) { this.large = value; }

    @JsonProperty("full")
    public String getFull() { return full; }
    @JsonProperty("full")
    public void setFull(String value) { this.full = value; }
}
