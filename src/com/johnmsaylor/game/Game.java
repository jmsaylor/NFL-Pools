package com.johnmsaylor.game;

import com.johnmsaylor.player.Team;

import java.time.Instant;

public class Game {
    public String id;
    public int reference;
    public Team home;
    public Team away;
    public Instant date;
    public boolean isFinal = false;
    public int homePoints;
    public int awayPoints;
    public String gameStatsJSON;

    public Game(Team home, Team away, Instant date) {
        this.home = home;
        this.away = away;
        this.date = date;
    }

    public Team getHome() {
        return home;
    }

    public Team getAway() {
        return away;
    }

    public String getDate() {
        return date.toString();
    }

    public int getHomePoints() {
        return homePoints;
    }

    public int getAwayPoints() {
        return awayPoints;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public void updateGameStats(){
        UpdateInterface
    }
}
