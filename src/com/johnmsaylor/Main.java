package com.johnmsaylor;

import com.google.gson.*;
import com.johnmsaylor.bet.BetTicket;
import com.johnmsaylor.game.Game;
import com.johnmsaylor.personnel.Team;
import com.johnmsaylor.sportsradar.Test;
import com.johnmsaylor.sportsradar.Utility;

import java.util.concurrent.ExecutionException;

public class Main {

    static String jsonString;

    public static void main(String[] args) {

        Gson gson = new Gson();
        try {
            jsonString = Test.getScheduleNFL();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        var jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();

        JsonArray arr = (JsonArray) jsonObject.get("weeks");

        for (JsonElement element : arr) {
            var week = element.getAsJsonObject();
            System.out.println(week.get("sequence"));
            for (JsonElement elem : week.get("games").getAsJsonArray()) {
                var game = elem.getAsJsonObject();
                JsonObject home = (JsonObject) game.get("home");
                JsonObject away = (JsonObject) game.get("away");
                System.out.println(home.get("name").getAsString().substring(0,3) + " vs. "  + away.get("name").getAsString().substring(0,3));
            }
        }

//        JsonObject week = (JsonObject) arr.get(0);
//
//        System.out.println(week.get("sequence"));
//
//        JsonArray games = (JsonArray) week.get("games");
//
//        JsonObject game = (JsonObject) games.get(0);
//
//        JsonObject home = (JsonObject) game.get("home");
//        JsonObject away = (JsonObject) game.get("away");
//
//        System.out.println(home.get("name"));
//        System.out.println(away.get("name"));

    }


}
