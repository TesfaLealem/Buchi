package com.yet.buchi.models.ApiModels;
import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Size {
    MEDIUM, SMALL;

    @JsonValue
    public String toValue() {
        switch (this) {
            case MEDIUM: return "Medium";
            case SMALL: return "Small";
        }
        return null;
    }

    @JsonCreator
    public static Size forValue(String value) throws IOException {
        if (value.equals("Medium")) return MEDIUM;
        if (value.equals("Small")) return SMALL;
        throw new IOException("Cannot deserialize Size");
    }
}
