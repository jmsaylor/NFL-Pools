package com.johnmsaylor.sportsradar;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.johnmsaylor.player.Player;
import com.johnmsaylor.security.Vault;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class GamePlayerStats {

    private static HttpClient client = HttpClient.newHttpClient();
    public static String gameID = "de740b16-4d86-4a04-afd0-61b3092799e1";
    public static String getGamePlayerStats() throws ExecutionException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.sportradar.us/nfl/official/trial/v6/en/games/" + gameID + "/statistics.json?api_key=" + Vault.getKeySportsRadar()))
                .header("accept", "application/json")
                .build();
        var responseFuture = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        var response = responseFuture.get();

        return response.body();
    }


    public static void getStatistics(String json) {
        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
        var stats = jsonObject.get("statistics").getAsJsonObject().get("home").getAsJsonObject();
        for (var stat : stats.keySet().toArray()) {
            if (!stats.get((String) stat).isJsonObject())
                continue;
            System.out.println(stat);
            var keys = stats.get((String) stat);
            System.out.println(keys.toString());
        }


    }


//    public static void getPlayers(JsonObject statistics) {
//        var stats = statistics.get("home").getAsJsonObject();
//        System.out.println(stats.toString());
//    }

//    public static void parsePlayers(String json) {
//        JsonArray players = getPlayers(getStatistics(json));
//        for (JsonElement player : players) {
//            JsonObject playerStats = player.getAsJsonObject();
//            System.out.println(playerStats.toString());
//        }
//    }

}
