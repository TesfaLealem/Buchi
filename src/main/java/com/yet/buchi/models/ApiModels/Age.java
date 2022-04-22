package com.yet.buchi.models;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Age {
    ADULT, BABY, YOUNG;

    @JsonValue
    public String toValue() {
        switch (this) {
            case ADULT: return "Adult";
            case BABY: return "Baby";
            case YOUNG: return "Young";
        }
        return null;
    }

    @JsonCreator
    public static Age forValue(String value) throws IOException {
        if (value.equals("Adult")) return ADULT;
        if (value.equals("Baby")) return BABY;
        if (value.equals("Young")) return YOUNG;
        throw new IOException("Cannot deserialize Age");
    }
}
