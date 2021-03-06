package com.company;

public class Game {
    boolean over;

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public Game() {
        this.over = false;
    }
}