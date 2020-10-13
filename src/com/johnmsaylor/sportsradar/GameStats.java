package com.johnmsaylor.sportsradar;

import com.google.gson.*;
import com.johnmsaylor.Console;
import com.johnmsaylor.game.UpdateInterface;
import com.johnmsaylor.player.Quarterback;
import com.johnmsaylor.stats.TeamGameSummary;

import java.util.ArrayList;
import java.util.List;

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

    public TeamGameSummary getAwaySummary() {
        Gson gson = new GsonBuilder().create();
        JsonObject jsonObject = getAwayStats().get("summary").getAsJsonObject();
        return gson.fromJson(jsonObject, TeamGameSummary.class);
    }

    public TeamGameSummary getHomeSummary() {
        Gson gson = new GsonBuilder().create();
        JsonObject jsonObject = getHomeStats().get("summary").getAsJsonObject();
        return gson.fromJson(jsonObject, TeamGameSummary.class);
    }

    public JsonObject getHomePassingStats(){
        return getHomeStats().get("passing").getAsJsonObject();
    }

    public List<Quarterback> getQuarterbackPassingStats() {
        Gson gson = new GsonBuilder().create();
        var quarterbacks = new ArrayList<Quarterback>();

        for (var quarterback : getHomePassingStats().get("players").getAsJsonArray()){
            quarterbacks.add(gson.fromJson(quarterback.getAsJsonObject(), Quarterback.class));
        }
        return quarterbacks;
    }


}

//    public static void parsePlayers(String json) {
//        JsonArray players = getPlayers(getStatistics(json));
//        for (JsonElement player : players) {
//            JsonObject playerStats = player.getAsJsonObject();
//            System.out.println(playerStats.toString());
//        }
//    }


