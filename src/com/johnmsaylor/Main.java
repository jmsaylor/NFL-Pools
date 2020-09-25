package com.johnmsaylor;

import com.johnmsaylor.bet.Bet;
import com.johnmsaylor.bet.Condition;
import com.johnmsaylor.bet.Win;
import com.johnmsaylor.game.GameMap;
import com.johnmsaylor.game.RegularSeason;
import com.johnmsaylor.game.RegularWeek;
import com.johnmsaylor.sportsradar.Test;
import com.johnmsaylor.user.User;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class Main {
    public static RegularSeason season;

    public static void main(String[] args) {

        try {
            season = Test.parseSchedule(Test.getScheduleNFL());
            TimeUnit.MILLISECONDS.sleep(1000);
//            Test.update(season);

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Console.showSeason(season);
        GameMap games = new GameMap(season);
        User john = new User("john");

        int refId = Console.chooseGame(season);
        Condition condition = new Win(games.map.get(refId), Console.inputTeam(games.map.get(refId)));
        Bet bet = new Bet(40, condition);
        String betId = bet.placeBet(john, true);
        System.out.println(bet.isWinner(betId));


    }
}
