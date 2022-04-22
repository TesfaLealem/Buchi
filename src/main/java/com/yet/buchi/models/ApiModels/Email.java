package com.yet.buchi.models.ApiModels;
import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Email {
    ALLJOY4_PAWS_YAHOO_COM, APPLY_WONDERDOGSRESCUE_ORG, KENTUCKYPETSALIVE_GMAIL_COM;

    @JsonValue
    public String toValue() {
        switch (this) {
            case ALLJOY4_PAWS_YAHOO_COM: return "alljoy4paws@yahoo.com";
            case APPLY_WONDERDOGSRESCUE_ORG: return "apply@wonderdogsrescue.org";
            case KENTUCKYPETSALIVE_GMAIL_COM: return "kentuckypetsalive@gmail.com";
        }
        return null;
    }

    @JsonCreator
    public static Email forValue(String value) throws IOException {
        if (value.equals("alljoy4paws@yahoo.com")) return ALLJOY4_PAWS_YAHOO_COM;
        if (value.equals("apply@wonderdogsrescue.org")) return APPLY_WONDERDOGSRESCUE_ORG;
        if (value.equals("kentuckypetsalive@gmail.com")) return KENTUCKYPETSALIVE_GMAIL_COM;
        throw new IOException("Cannot deserialize Email");
    }
}
