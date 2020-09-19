package com.johnmsaylor.sportsradar;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ExecutionException;

public class Test {
//    private static String key = ;

    private static HttpClient client = HttpClient.newHttpClient();

    public static void getScheduleNFL() throws ExecutionException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.sportradar.us/nfl/official/trial/v6/en/games/2020/reg/schedule.json?api_key=<key>"))
                .header("accept", "application/json")
                .build();
        var responseFuture = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        var response = responseFuture.get();

        System.out.println(response.body());
    }

    public static void requestNASA() throws ExecutionException, InterruptedException {

        var request = HttpRequest.newBuilder(URI.create("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY")
        ).header("accept", "application/json").build();

        var responseFuture = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        var response = responseFuture.get();

        System.out.println(response.body());
    }
}
