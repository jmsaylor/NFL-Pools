package com.johnmsaylor.bet;

import com.johnmsaylor.game.Game;
import com.johnmsaylor.user.User;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Bet {
    public long id;
    public int betAmount;
    public Condition condition;
    public HashMap<Boolean, List<String>> bets;


    public Bet(int betAmount, Condition condition) {
        this.id = (long) (Math.random() * 100000000);
        this.betAmount = betAmount;
        this.condition = condition;
        this.bets.put(true, new ArrayList<>());
        this.bets.put(false, new ArrayList<>());
    }

    public String placeBet(User user, boolean bet) {
        List<String> list = bets.get(bet);
        String betId = user.name.substring(0, 3).toUpperCase() + Long.toString(id, 10);
        list.add(betId);
        bets.put(bet, list);
        return betId;
    }

    public boolean isWinner(String betId) {
        return  bets.get(condition.checkCondition()).contains(betId);
    }

}
