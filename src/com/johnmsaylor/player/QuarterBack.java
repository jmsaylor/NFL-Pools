package com.johnmsaylor.player;

public class QuarterBack extends Player {

    private int sacks;

    public QuarterBack(String name, int number) {
        super(name, number);
    }

    public int getSacks() {
        return sacks;
    }

    public void setSacks(int sacks) {
        this.sacks = sacks;
    }
}
