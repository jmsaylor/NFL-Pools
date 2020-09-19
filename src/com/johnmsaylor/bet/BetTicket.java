package com.johnmsaylor.bet;

import com.johnmsaylor.game.Game;
import com.johnmsaylor.personnel.Team;

public class BetTicket {
    public Team win;
    public Game game;

    public BetTicket(Game game) {
        this.game = game;
    }

    public void setWin(InputInterface input) {
        win = input.inputTeam(game);
    }

}
