package com.johnmsaylor.bet;

import com.johnmsaylor.user.User;

public interface Condition {
    boolean isBettingOpen();
    boolean isFinal();
    boolean checkCondition();
}

//can we create a static method that will use implementation of isBetting open like Condition.isBettingOpen(Condition Win)
