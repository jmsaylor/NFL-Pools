package com.johnmsaylor.bet;

import com.johnmsaylor.game.Game;
import com.johnmsaylor.user.User;

import java.time.Instant;
import java.util.HashMap;

public abstract class Bet {
    public int maxTakers;
    public HashMap<User, Boolean> betMap;
    public int betAmount;


    public Bet(int betAmount, int maxTakers) {
        this.betAmount = betAmount;
        this.maxTakers = maxTakers;


    }

    public static boolean isBettingOpen(Game game) {
        return Instant.now().isBefore(game.date);
    }
}
