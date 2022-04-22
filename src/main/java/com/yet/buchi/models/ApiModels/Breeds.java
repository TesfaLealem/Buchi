package com.yet.buchi.models.ApiModels;
import com.fasterxml.jackson.annotation.*;

public class Breeds {
    private String primary;
    private String secondary;
    private boolean mixed;
    private boolean unknown;

    @JsonProperty("primary")
    public String getPrimary() { return primary; }
    @JsonProperty("primary")
    public void setPrimary(String value) { this.primary = value; }

    @JsonProperty("secondary")
    public String getSecondary() { return secondary; }
    @JsonProperty("secondary")
    public void setSecondary(String value) { this.secondary = value; }

    @JsonProperty("mixed")
    public boolean getMixed() { return mixed; }
    @JsonProperty("mixed")
    public void setMixed(boolean value) { this.mixed = value; }

    @JsonProperty("unknown")
    public boolean getUnknown() { return unknown; }
    @JsonProperty("unknown")
    public void setUnknown(boolean value) { this.unknown = value; }
}
