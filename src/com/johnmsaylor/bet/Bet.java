package com.johnmsaylor.bet;

import com.johnmsaylor.game.Game;
import com.johnmsaylor.user.User;

import java.time.Instant;
import java.util.HashMap;

public abstract class Bet {
    public int betAmount;


    public Bet(int betAmount) {
        this.betAmount = betAmount;
    }

    public static boolean isBettingOpen(Game game) {
        return Instant.now().isBefore(game.date);
    }
}
