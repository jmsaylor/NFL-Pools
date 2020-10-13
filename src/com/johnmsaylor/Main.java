package com.johnmsaylor;

import com.johnmsaylor.game.RegularSeason;
import com.johnmsaylor.sportsradar.GameStats;

public class Main {

    public static void main(String[] args) {

        GameStats gameStats = new GameStats("de740b16-4d86-4a04-afd0-61b3092799e1");
        for (var qb : gameStats.getQuarterbackPassingStats()) {
            Console.testToJSON(qb);
        }

    }

}
