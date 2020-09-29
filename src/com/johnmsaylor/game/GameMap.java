package com.johnmsaylor.game;

import java.util.HashMap;
import java.util.Map;

public class GameMap {
    public Map<Integer, Game> mapObjects = new HashMap<>();

    public GameMap(RegularSeason season) {
        for (RegularWeek week : season.season) {
            for (Game game : week.games) {
                mapObjects.put(game.reference, game);
            }
        }
    }

    public String getGameID(int reference) {
        return mapObjects.get(reference).id;
    }
}
