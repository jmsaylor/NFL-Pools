package com.johnmsaylor.sportsradar;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Schedule {

    public static boolean isClosed(JsonObject json) {
        String status = json.get("status").getAsString();
        return status.equals("closed");
    }

}
