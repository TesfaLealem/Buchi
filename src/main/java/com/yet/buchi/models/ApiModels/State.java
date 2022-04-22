package com.yet.buchi.models.ApiModels;
import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum State {
    CA, KY, OH;

    @JsonValue
    public String toValue() {
        switch (this) {
            case CA: return "CA";
            case KY: return "KY";
            case OH: return "OH";
        }
        return null;
    }

    @JsonCreator
    public static State forValue(String value) throws IOException {
        if (value.equals("CA")) return CA;
        if (value.equals("KY")) return KY;
        if (value.equals("OH")) return OH;
        throw new IOException("Cannot deserialize State");
    }
}
