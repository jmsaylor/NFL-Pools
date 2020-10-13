package com.johnmsaylor.stats;

public class TeamGameSummary {
    public String possession_time;
    public int play_count;
    public int total_yards;
    public int turnovers;
    public int fumbles;
    public int safeties;

    public String getPossession_time() {
        return possession_time;
    }

    public int getPlay_count() {
        return play_count;
    }

    public int getTurnovers() {
        return turnovers;
    }

    public int getTotal_yards() {
        return total_yards;
    }

    public int getFumbles() {
        return fumbles;
    }

    public int getSafeties() {
        return safeties;
    }
}
