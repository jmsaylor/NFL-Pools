package com.johnmsaylor.game;

import java.util.HashMap;

public class GameMap {
    public HashMap<Integer, Game> map = new HashMap<>();

    public GameMap(RegularSeason season) {
        for (RegularWeek week : season.season) {
            for (Game game : week.games) {
                map.put(game.reference, game);
            }
        }
    }
}
