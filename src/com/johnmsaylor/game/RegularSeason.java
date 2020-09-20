package com.johnmsaylor.game;

import java.util.ArrayList;
import java.util.List;

public class RegularSeason {
    public int year;
    public List<RegularWeek> season;

    public RegularSeason(int year) {
        this.year = year;
        this.season = new ArrayList<>();
    }

    public void addWeek(RegularWeek week) {
        this.season.add(week);
    }
}
