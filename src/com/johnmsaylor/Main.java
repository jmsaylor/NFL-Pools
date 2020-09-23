package com.johnmsaylor;

import com.johnmsaylor.game.RegularSeason;
import com.johnmsaylor.game.RegularWeek;
import com.johnmsaylor.sportsradar.Test;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class Main {
    public static RegularSeason season;

    public static void main(String[] args) {

        try {
            season = Test.parseSchedule(Test.getScheduleNFL());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
