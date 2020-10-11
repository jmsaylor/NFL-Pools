package com.johnmsaylor.bet;

import com.johnmsaylor.game.Game;
import com.johnmsaylor.player.Team;

import java.time.Instant;

public class Win implements Condition {
    public Game game;
    public Team winner;

    public Win(Game game, Team winner) {
        this.game = game;
        this.winner = winner;
    }

    @Override
    public boolean checkCondition() {
        boolean result = false;
        if (game.isFinal) {
            if (game.getAwayPoints() > game.getHomePoints() && winner.toString().equals(game.getAway().toString())) {
                result = true;
            }
            if (game.getHomePoints() > game.getAwayPoints() && winner.toString().equals(game.getHome().toString())) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean isBettingOpen() {
        return Instant.now().isBefore(game.date);
    }

    @Override
    public boolean isFinal() {
        return game.isFinal;
    }


}
