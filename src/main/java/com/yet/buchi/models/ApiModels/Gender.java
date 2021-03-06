package com.yet.buchi.models.ApiModels;
import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Gender {
    FEMALE, MALE;

    @JsonValue
    public String toValue() {
        switch (this) {
            case FEMALE: return "Female";
            case MALE: return "Male";
        }
        return null;
    }

    @JsonCreator
    public static Gender forValue(String value) throws IOException {
        if (value.equals("Female")) return FEMALE;
        if (value.equals("Male")) return MALE;
        throw new IOException("Cannot deserialize Gender");
    }
}
