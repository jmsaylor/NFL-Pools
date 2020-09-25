package com.johnmsaylor.bet;

import com.johnmsaylor.game.Game;

public class SimpleWin extends Bet {
    public Game game;

    public SimpleWin(Game game, int amount) {
        super(amount);
        this.game = game;
    }
}
