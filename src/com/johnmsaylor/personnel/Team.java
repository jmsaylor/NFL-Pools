package com.johnmsaylor.personnel;

import com.johnmsaylor.game.Game;

import java.util.List;

public class Team {
    public String name;
    public List<Game> games;

    public Team(String name) {
        this.name = name;
    }
}
