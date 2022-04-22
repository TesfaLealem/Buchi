package com.yet.buchi.models.ApiModels;
import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Species {
    CAT, DOG;

    @JsonValue
    public String toValue() {
        switch (this) {
            case CAT: return "Cat";
            case DOG: return "Dog";
        }
        return null;
    }

    @JsonCreator
    public static Species forValue(String value) throws IOException {
        if (value.equals("Cat")) return CAT;
        if (value.equals("Dog")) return DOG;
        throw new IOException("Cannot deserialize Species");
    }
}
