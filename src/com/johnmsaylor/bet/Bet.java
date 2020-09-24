package com.johnmsaylor.bet;

import com.johnmsaylor.user.User;

import java.util.HashMap;

public abstract class Bet {
    public int maxTakers;
    public HashMap<User, Boolean> betMap;
    public int betAmount;


    public Bet(int betAmount, int maxTakers) {
        this.betAmount = betAmount;
        this.maxTakers = maxTakers;


    }

    public void bet(User user, boolean bet) {

    }
}
