package com.johnmsaylor;

import com.johnmsaylor.game.RegularSeason;
import com.johnmsaylor.sportsradar.GamePlayerStats;
import com.johnmsaylor.sportsradar.JDocTest;
import com.johnmsaylor.sportsradar.Test;

import java.util.concurrent.ExecutionException;

public class Main {

    public static RegularSeason season;

    public static void main(String[] args) {

//        try {
//            season = Test.parseSchedule(Test.getScheduleNFL());
////            System.out.println(Test.getScheduleNFL());
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        Console.showSeason(season);

            JDocTest.showJson();

    }

}
