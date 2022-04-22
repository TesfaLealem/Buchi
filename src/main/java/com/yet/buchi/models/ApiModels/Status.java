package com.yet.buchi.models.ApiModels;
import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Status {
    ADOPTABLE;

    @JsonValue
    public String toValue() {
        switch (this) {
            case ADOPTABLE: return "adoptable";
        }
        return null;
    }

    @JsonCreator
    public static Status forValue(String value) throws IOException {
        if (value.equals("adoptable")) return ADOPTABLE;
        throw new IOException("Cannot deserialize Status");
    }
}
