package com.johnmsaylor;

import com.johnmsaylor.bet.Bet;
import com.johnmsaylor.game.Game;
import com.johnmsaylor.game.GameMap;
import com.johnmsaylor.game.RegularSeason;
import com.johnmsaylor.game.RegularWeek;
import com.johnmsaylor.team.Team;

import java.util.Scanner;

public class Console {

    public static void main(RegularSeason season) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter week, or 0 to quit");
            int selectWeek = scanner.nextInt();
            if (selectWeek == 0) break;
            RegularWeek week = season.season.get(selectWeek);
            Console.showWeek(week);
        }
    }

    public static Team inputTeam(Game game) {
        Scanner scanner;
        int input;
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

    public static int chooseGame(RegularSeason season) {
        var scanner = new Scanner(System.in);
        int input;
        while (true) {
            System.out.print("Choose Week: ");
            input = scanner.nextInt();
            for (RegularWeek week : season.season) {
                if (week.getSequence() == input) {
                    for (Game game : week.games) {
                        Console.showGame(game);
                    }
                }
            }
            System.out.print("Enter 4-digit game reference ID (or 0 to choose different week): ");
            int refId = scanner.nextInt();
            if (refId != 0)
                return refId;
        }

    }

    public static void showTicket(Bet bet) {
    }

    public static Bet takeBet() {
        var scanner = new Scanner(System.in);
        System.out.println();

        return null;
    }

    public static RegularWeek selectWeek(RegularSeason season) {
        var scanner = new Scanner(System.in);
        while (true) {

            break;
        }
        return null;
    }

    public static void showGame(Game game) {
        System.out.print(game.reference);
        System.out.print(game.getHome());
        System.out.print(" vs. ");
        System.out.print(game.getAway());
        System.out.print(" @ ");
        System.out.println(game.getDate());
        if (game.isFinal) {
            System.out.print("Final Score: ");
            System.out.print(game.home.toString().substring(0,3) + ": " + game.homePoints);
            System.out.print("/");
            System.out.println(game.away.toString().substring(0,3) + ": " + game.awayPoints);
        }

    }

    public static void showWeek(RegularWeek week) {
        System.out.println("REGULAR SEASON WEEK: " + week.sequence);
        for (var game : week.games) {
            showGame(game);
        }
    }

    public static void showSeason(RegularSeason season) {
        for (RegularWeek week : season.season) {
            for (Game game : week.games) {
                Console.showGame(game);
            }
        }
    }

}
