package com.johnmsaylor.player;

public abstract class DefensivePlayer extends Player {
    private int sacks;
    private int interceptions;
    private int tackles;

    public DefensivePlayer(){};

    public DefensivePlayer(String name, int number, String id) {
        super(name, number, id);
    }

    public int getSacks() {
        return sacks;
    }

    public void setSacks(int sacks) {
        this.sacks = sacks;
    }

    public int getInterceptions() {
        return interceptions;
    }

    public void setInterceptions(int interceptions) {
        this.interceptions = interceptions;
    }

    public int getTackles() {
        return tackles;
    }

    public void setTackles(int tackles) {
        this.tackles = tackles;
    }
}
