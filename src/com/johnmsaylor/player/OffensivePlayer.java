package com.johnmsaylor.player;

public abstract class OffensivePlayer extends Player {
    private int touchDowns;
    private int totalYards;
    private int longestPlay;
    private int longestTouchDown;

    public OffensivePlayer(String name, int number, String id) {
        super(name, number, id);
    }

    public int getTouchDowns() {
        return touchDowns;
    }

    public void setTouchDowns(int touchDowns) {
        this.touchDowns = touchDowns;
    }

    public int getTotalYards() {
        return totalYards;
    }

    public void setTotalYards(int totalYards) {
        this.totalYards = totalYards;
    }

    public int getLongestPlay() {
        return longestPlay;
    }

    public void setLongestPlay(int longestPlay) {
        this.longestPlay = longestPlay;
    }

    public int getLongestTouchDown() {
        return longestTouchDown;
    }

    public void setLongestTouchDown(int longestTouchDown) {
        this.longestTouchDown = longestTouchDown;
    }
}
