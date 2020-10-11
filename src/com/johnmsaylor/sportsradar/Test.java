package com.johnmsaylor.sportsradar;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.johnmsaylor.game.Game;
import com.johnmsaylor.game.RegularSeason;
import com.johnmsaylor.game.RegularWeek;
import com.johnmsaylor.player.Team;
import com.johnmsaylor.security.Vault;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class Test {

    private static HttpClient client = HttpClient.newHttpClient();

    public static String getScheduleNFL() throws ExecutionException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.sportradar.us/nfl/official/trial/v6/en/games/2020/reg/schedule.json?api_key=" + Vault.getKeySportsRadar()))
                .header("accept", "application/json")
                .build();
        var responseFuture = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        var response = responseFuture.get();

        return response.body();
    }

    public static void requestNASA() throws ExecutionException, InterruptedException {

        var request = HttpRequest.newBuilder(URI.create("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY")
        ).header("accept", "application/json").build();

        var responseFuture = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        var response = responseFuture.get();

        System.out.println(response);
    }

    public static RegularSeason parseSchedule(String json) {
        var season = new RegularSeason(2020);
        HashMap<String, Team> teams = new HashMap<>();

        var jsonObject = JsonParser.parseString(json).getAsJsonObject();

        JsonArray arr = (JsonArray) jsonObject.get("weeks");

        for (JsonElement element : arr) {
            var week = element.getAsJsonObject();
            RegularWeek regWeek = new RegularWeek(week.get("sequence").getAsInt());
            for (JsonElement elem : week.get("games").getAsJsonArray()) {
                var game = elem.getAsJsonObject();
                JsonObject home = (JsonObject) game.get("home");
                JsonObject away = (JsonObject) game.get("away");
                String homeTeam = home.get("name").getAsString();
                String awayTeam = away.get("name").getAsString();
                if (!teams.containsKey(homeTeam)) {
                    teams.put(homeTeam, new Team(homeTeam));
                }
                if (!teams.containsKey(awayTeam)) {
                    teams.put(awayTeam, new Team(awayTeam));
                }
                Game newGame = new Game(teams.get(homeTeam), teams.get(awayTeam),Utility.formatDate(game.get("scheduled").getAsString()));
                newGame.setId(game.get("id").getAsString());
                newGame.setReference(game.get("reference").getAsInt());
                regWeek.addGame(newGame);
            }
            season.addWeek(regWeek);
        }
        return season;
    }

    public static void update(RegularSeason season) throws ExecutionException, InterruptedException {
        HashMap<Integer, Game> references = new HashMap<>();

        for (RegularWeek week : season.season) {
            for (Game game : week.games) {
                references.put(game.reference, game);
            }
        }

        String jsonString = getScheduleNFL();
//        JsonReader reader = new JsonReader(jsonString);
        try {

            var json = JsonParser.parseString(jsonString).getAsJsonObject();

            for (JsonElement elem : json.get("weeks").getAsJsonArray()) {
                var week = elem.getAsJsonObject();
                for (JsonElement game : week.get("games").getAsJsonArray()) {
                    var gameInfo = game.getAsJsonObject();
                    int gameReference = gameInfo.get("reference").getAsInt();
                    if (references.get(gameReference).isFinal) {
                        continue;
                    } else if (gameInfo.get("status").getAsString().equals("closed")) {
                        var scores = gameInfo.get("scoring").getAsJsonObject();
                        var updatedGame = references.get(gameReference);
                        updatedGame.homePoints = scores.get("home_points").getAsInt();
                        updatedGame.awayPoints = scores.get("away_points").getAsInt();
                        updatedGame.isFinal = true;
                    }
                }
            }
        } catch (Exception exception) {
            System.out.println(exception.toString());
        }

    }
}
