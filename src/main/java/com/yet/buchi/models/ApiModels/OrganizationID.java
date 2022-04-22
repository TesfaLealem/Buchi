package com.yet.buchi.models.ApiModels;
import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum OrganizationID {
    CA2686, KY382, OH1213;

    @JsonValue
    public String toValue() {
        switch (this) {
            case CA2686: return "CA2686";
            case KY382: return "KY382";
            case OH1213: return "OH1213";
        }
        return null;
    }

    @JsonCreator
    public static OrganizationID forValue(String value) throws IOException {
        if (value.equals("CA2686")) return CA2686;
        if (value.equals("KY382")) return KY382;
        if (value.equals("OH1213")) return OH1213;
        throw new IOException("Cannot deserialize OrganizationID");
    }
}
