package com.yet.buchi.models.ApiModels;
import com.fasterxml.jackson.annotation.*;

public class Attributes {
    private boolean spayedNeutered;
    private boolean houseTrained;
    private Boolean declawed;
    private boolean specialNeeds;
    private boolean shotsCurrent;

    @JsonProperty("spayed_neutered")
    public boolean getSpayedNeutered() { return spayedNeutered; }
    @JsonProperty("spayed_neutered")
    public void setSpayedNeutered(boolean value) { this.spayedNeutered = value; }

    @JsonProperty("house_trained")
    public boolean getHouseTrained() { return houseTrained; }
    @JsonProperty("house_trained")
    public void setHouseTrained(boolean value) { this.houseTrained = value; }

    @JsonProperty("declawed")
    public Boolean getDeclawed() { return declawed; }
    @JsonProperty("declawed")
    public void setDeclawed(Boolean value) { this.declawed = value; }

    @JsonProperty("special_needs")
    public boolean getSpecialNeeds() { return specialNeeds; }
    @JsonProperty("special_needs")
    public void setSpecialNeeds(boolean value) { this.specialNeeds = value; }

    @JsonProperty("shots_current")
    public boolean getShotsCurrent() { return shotsCurrent; }
    @JsonProperty("shots_current")
    public void setShotsCurrent(boolean value) { this.shotsCurrent = value; }
}
