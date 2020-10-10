package com.johnmsaylor.bet;

import com.johnmsaylor.Console;
import com.johnmsaylor.game.Game;
import com.johnmsaylor.team.Team;

import java.util.HashMap;
import java.util.List;

public class Pick4Bet {
    public HashMap<Game, Team> bets = new HashMap<>();

    public Pick4Bet(List<Game> games) {
        for (Game game : games) {
            this.bets.put(game, Console.inputTeam(game));
        }
    }
}
