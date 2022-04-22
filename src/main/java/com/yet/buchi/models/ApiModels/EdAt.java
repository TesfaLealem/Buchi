package com.yet.buchi.models.ApiModels;
import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum EdAt {
    THE_20220419_T06_01590000, THE_20220419_T06_02370000, THE_20220419_T06_04250000;

    @JsonValue
    public String toValue() {
        switch (this) {
            case THE_20220419_T06_01590000: return "2022-04-19T06:01:59+0000";
            case THE_20220419_T06_02370000: return "2022-04-19T06:02:37+0000";
            case THE_20220419_T06_04250000: return "2022-04-19T06:04:25+0000";
        }
        return null;
    }

    @JsonCreator
    public static EdAt forValue(String value) throws IOException {
        if (value.equals("2022-04-19T06:01:59+0000")) return THE_20220419_T06_01590000;
        if (value.equals("2022-04-19T06:02:37+0000")) return THE_20220419_T06_02370000;
        if (value.equals("2022-04-19T06:04:25+0000")) return THE_20220419_T06_04250000;
        throw new IOException("Cannot deserialize EdAt");
    }
}
