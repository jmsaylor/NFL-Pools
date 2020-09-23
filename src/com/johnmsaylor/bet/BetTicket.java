package com.johnmsaylor.bet;

import com.johnmsaylor.Console;
import com.johnmsaylor.game.Game;
import com.johnmsaylor.personnel.Team;
import com.johnmsaylor.user.User;

import java.util.HashMap;
import java.util.List;

public abstract class BetTicket {
    public HashMap<User, boolean> betMap;
    public int amount;


    public BetTicket(amount) {
        this.amount = amount;

    }

    public void bet(User user, boolean bet) {
        
    }
}
