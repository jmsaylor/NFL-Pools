package com.johnmsaylor.team;

public class Team {
    public String name;

    public Team(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
