package com.yet.buchi.models.ApiModels;
import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum City {
    FARMERSVILLE, LONG_BEACH, LOUISVILLE;

    @JsonValue
    public String toValue() {
        switch (this) {
            case FARMERSVILLE: return "Farmersville";
            case LONG_BEACH: return "Long Beach";
            case LOUISVILLE: return "Louisville";
        }
        return null;
    }

    @JsonCreator
    public static City forValue(String value) throws IOException {
        if (value.equals("Farmersville")) return FARMERSVILLE;
        if (value.equals("Long Beach")) return LONG_BEACH;
        if (value.equals("Louisville")) return LOUISVILLE;
        throw new IOException("Cannot deserialize City");
    }
}
