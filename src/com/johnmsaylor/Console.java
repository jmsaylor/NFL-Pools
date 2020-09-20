package com.johnmsaylor;

import com.johnmsaylor.bet.BetTicket;
import com.johnmsaylor.bet.InputInterface;
import com.johnmsaylor.game.Game;
import com.johnmsaylor.game.RegularSeason;
import com.johnmsaylor.game.RegularWeek;
import com.johnmsaylor.personnel.Team;

import java.util.Scanner;

public class Console implements InputInterface {
    public Scanner scanner;
    public int input;

    public Team inputTeam(Game game) {
        while (true) {
            scanner = new Scanner(System.in);
            System.out.println("Choose your team - 1: " + game.getHome() + " Or 2: " + game.getAway());
            input = scanner.nextInt();
            if (input == 1 | input == 2) {
                break;
            }
            System.out.println("Enter 1 for home, 2 for away");
        }
        return input == 1 ? game.home : game.away;
    }

    public static void showTicket(BetTicket bet) {
        System.out.println("#######################");
        System.out.println(bet.game.getAway() + " @ " + bet.game.getHome());
        System.out.println("BET: " + bet.win + " to WIN");
        System.out.println("#######################");
    }

    public static void showGame(Game game) {
        System.out.print(game.getHome());
        System.out.print(" vs. ");
        System.out.print(game.getAway());
        System.out.print(" @ ");
        System.out.println(game.getDate());
    }

    public static void showSeason(RegularSeason season) {
        for (RegularWeek week : season.season) {
            for (Game game : week.games) {
                Console.showGame(game);
            }
        }
    }

}
