package com.johnmsaylor.player;

public class Team {
    public String name;

    public Team(){};

    public Team(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
