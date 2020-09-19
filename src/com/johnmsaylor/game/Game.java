package com.johnmsaylor.game;

import com.johnmsaylor.personnel.Team;

import java.time.Instant;

public class Game {
    public Team home;
    public Team away;
    public Instant date;

    public Game(Team home, Team away, String date) {
        this.home = home;
        this.away = away;
        this.date = Instant.parse(date);

    }

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

    public Instant getDate() {
        return date;
    }
}
