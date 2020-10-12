package com.johnmsaylor.sportsradar;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.johnmsaylor.security.Vault;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.util.concurrent.ExecutionException;

public abstract class BaseAPI {

    public static String getScheduleNFL(String year) throws ExecutionException, InterruptedException {
        String rawJSON = "";
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create("https://api.sportradar.us/nfl/official/trial/v6/en/games/" + year +"/reg/schedule.json?api_key=" + Vault.getKeySportsRadar()))
                        .header("accept", "application/json")
                        .build();
                var responseFuture = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
                var response = responseFuture.get();

                rawJSON = response.body();
            } catch (ExecutionException e) {
                System.out.println(e);
            } catch (InterruptedException e) {
                System.out.println(e);
            }

            return rawJSON;
    }

//    public static String gameID = "de740b16-4d86-4a04-afd0-61b3092799e1";
    public static String getGamePlayerStats(String gameID) {
        String rawJSON = "";
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.sportradar.us/nfl/official/trial/v6/en/games/" + gameID + "/statistics.json?api_key=" + Vault.getKeySportsRadar()))
                    .header("accept", "application/json")
                    .build();
            var responseFuture = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
            var response = responseFuture.get();

            rawJSON = response.body();

        } catch (ExecutionException e) {
            System.out.println(e);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        return rawJSON;
    }

    public static String getGamePlayerStats(){
        return getGamePlayerStats("de740b16-4d86-4a04-afd0-61b3092799e1");
    }

}
