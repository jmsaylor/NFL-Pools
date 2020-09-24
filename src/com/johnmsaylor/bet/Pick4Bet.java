package com.johnmsaylor.bet;

import com.johnmsaylor.Console;
import com.johnmsaylor.game.Game;
import com.johnmsaylor.personnel.Team;

import java.util.HashMap;
import java.util.List;

public class Pick4Bet {
    public HashMap<Game, Team> bets = new HashMap<>();

    public Pick4Bet(List<Game> games) {
        for (var game : games) {
            this.bets.put(game, Console.inputTeam(game));
        }
    }
}