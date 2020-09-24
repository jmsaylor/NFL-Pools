package com.johnmsaylor.game;

import com.johnmsaylor.team.Team;

import java.time.Instant;

public class Game {
    public Team home;
    public Team away;
    public Instant date;
    public int reference;

    public Game(Team home, Team away, Instant date, int reference) {
        this.reference = reference;
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

}
