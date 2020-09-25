package com.johnmsaylor.game;

import java.util.ArrayList;
import java.util.List;

public class RegularWeek {
    public int sequence;
    public List<Game> games;

    public RegularWeek(int sequence) {
        this.sequence = sequence;
        this.games = new ArrayList<>();
    }

    public int getSequence() {
        return sequence;
    }

    public void addGame(Game game) {
        games.add(game);
    }
}
