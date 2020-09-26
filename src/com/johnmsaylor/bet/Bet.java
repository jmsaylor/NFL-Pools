package com.johnmsaylor.bet;


import com.johnmsaylor.user.User;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Bet {
    public String id;
    public int betAmount;
    public Condition condition;
    public List<String> trueBets;
    public List<String> falseBets;

    public Bet(int betAmount, Condition condition) {
        this.id = UUID.randomUUID().toString();
        this.betAmount = betAmount;
        this.condition = condition;
        this.trueBets = new ArrayList<>();
        this.falseBets = new ArrayList<>();
    }

    public String placeBet(User user, boolean bet) {
        String betId = UUID.randomUUID().toString();
        if (bet) {
            trueBets.add(betId);
        } else {
            falseBets.add(betId);
        }
        return betId;
    }

    public boolean isWinner(String betId) {
        List<String> winningBets = condition.checkCondition() ? trueBets : falseBets;
        return  winningBets.contains(betId);
    }

    public boolean isBettingOpen() {
        return condition.isBettingOpen();
    }

    public boolean isFinal() {
        return condition.isFinal();
    }
}
