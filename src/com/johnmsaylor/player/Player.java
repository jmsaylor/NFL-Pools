package com.johnmsaylor.player;

public abstract class Player {
    public String id;
    public String name;
    public int number;

    public Player(String name, int number, String id) {
        this.name = name;
        this.number = number;
        this.id = id;
    }
}
