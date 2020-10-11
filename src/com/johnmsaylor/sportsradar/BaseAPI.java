package com.johnmsaylor.sportsradar;
import com.johnmsaylor.security.Vault;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.util.concurrent.ExecutionException;

public abstract class BaseAPI {

    public static String getScheduleNFL(String year) throws ExecutionException, InterruptedException {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.sportradar.us/nfl/official/trial/v6/en/games/" + year +"/reg/schedule.json?api_key=" + Vault.getKeySportsRadar()))
                    .header("accept", "application/json")
                    .build();
            var responseFuture = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
            var response = responseFuture.get();

            return response.body();
    }

    public static String getGamePlayerStats(String gameID) throws ExecutionException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.sportradar.us/nfl/official/trial/v6/en/games/" + gameID + "/statistics.json?api_key=" + Vault.getKeySportsRadar()))
                .header("accept", "application/json")
                .build();
        var responseFuture = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        var response = responseFuture.get();

        return response.body();
    }
}
