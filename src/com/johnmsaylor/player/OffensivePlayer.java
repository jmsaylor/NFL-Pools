package com.johnmsaylor.player;

public abstract class OffensivePlayer extends Player {
    private int touchdowns;
    private int yards;
    private int longest;
    private int longest_touchdown;
    public int redzone_attempts;
    public int tlost_yards;

    public OffensivePlayer() {};

    public int getTouchdowns() {
        return touchdowns;
    }

    public int getYards() {
        return yards;
    }

    public int getLongest() {
        return longest;
    }

    public int getLongest_touchdown() {
        return longest_touchdown;
    }

    public int getRedzone_attempts() {
        return redzone_attempts;
    }

    public int getTlost_yards() {
        return tlost_yards;
    }
}

