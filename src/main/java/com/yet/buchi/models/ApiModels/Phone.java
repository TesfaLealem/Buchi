package com.yet.buchi.models.ApiModels;
import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Phone {
    THE_5027772968;

    @JsonValue
    public String toValue() {
        switch (this) {
            case THE_5027772968: return "(502) 777-2968";
        }
        return null;
    }

    @JsonCreator
    public static Phone forValue(String value) throws IOException {
        if (value.equals("(502) 777-2968")) return THE_5027772968;
        throw new IOException("Cannot deserialize Phone");
    }
}
