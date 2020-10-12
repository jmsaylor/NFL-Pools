package com.johnmsaylor.sportsradar;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.johnmsaylor.game.UpdateInterface;
import com.johnmsaylor.player.Player;
import com.johnmsaylor.security.Vault;
import com.johnmsaylor.stats.Summary;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class GameStats extends BaseAPI implements UpdateInterface {
    private String gameID;
    private String rawJSON;

    public GameStats(String gameID) {
        this.gameID = gameID;
        this.rawJSON = getGamePlayerStats(gameID);
    }

    private JsonObject getStatistics() {
        JsonObject jsonObject = JsonParser.parseString(rawJSON).getAsJsonObject();
        return jsonObject.get("statistics").getAsJsonObject();
    }

    private JsonObject getHomeStats() {
        return getStatistics().get("home").getAsJsonObject();
    }

    public JsonObject getAwayStats() {
        return getStatistics().get("away").getAsJsonObject();
    }

    public Summary getHomeSummary() {
        Gson gson = new GsonBuilder().create();
        JsonObject jsonObject = getHomeStats().get("summary").getAsJsonObject();
        return gson.fromJson(jsonObject, Summary.class);
    }


}

//    public static void parsePlayers(String json) {
//        JsonArray players = getPlayers(getStatistics(json));
//        for (JsonElement player : players) {
//            JsonObject playerStats = player.getAsJsonObject();
//            System.out.println(playerStats.toString());
//        }
//    }


