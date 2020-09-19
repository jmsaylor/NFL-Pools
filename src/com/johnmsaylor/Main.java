package com.johnmsaylor;

import com.johnmsaylor.bet.BetTicket;
import com.johnmsaylor.game.Game;
import com.johnmsaylor.personnel.Team;
import com.johnmsaylor.sportsradar.Utility;

public class Main {

    public static void main(String[] args) {
        String example = "2020-12-20T18:00:00+00:00";

        var team1 = new Team("Dolphins");
        var team2 = new Team("Patriots");
        var game = new Game(team1,team2,Utility.formatDate(example));
        var bet = new BetTicket(game);
        var console = new Console();
        bet.setWin(console);
        Console.showTicket(bet);
    }


}
