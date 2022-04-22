package com.yet.buchi.models.ApiModels;
import com.fasterxml.jackson.annotation.*;

public class Colors {
    private String primary;
    private String secondary;
    private Object tertiary;

    @JsonProperty("primary")
    public String getPrimary() { return primary; }
    @JsonProperty("primary")
    public void setPrimary(String value) { this.primary = value; }

    @JsonProperty("secondary")
    public String getSecondary() { return secondary; }
    @JsonProperty("secondary")
    public void setSecondary(String value) { this.secondary = value; }

    @JsonProperty("tertiary")
    public Object getTertiary() { return tertiary; }
    @JsonProperty("tertiary")
    public void setTertiary(Object value) { this.tertiary = value; }
}
