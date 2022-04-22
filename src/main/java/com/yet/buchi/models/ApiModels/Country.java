package com.yet.buchi.models.ApiModels;
import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Country {
    US;

    @JsonValue
    public String toValue() {
        switch (this) {
            case US: return "US";
        }
        return null;
    }

    @JsonCreator
    public static Country forValue(String value) throws IOException {
        if (value.equals("US")) return US;
        throw new IOException("Cannot deserialize Country");
    }
}
