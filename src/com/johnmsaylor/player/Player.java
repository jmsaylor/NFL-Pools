package com.johnmsaylor.player;

public abstract class Player {
    public String id;
    public String name;
    public String position;
    public int jersey;

    public Player(){};

    public Player(String name, int jersey, String id) {
        this.name = name;
        this.jersey = jersey;
        this.id = id;
    }
}
