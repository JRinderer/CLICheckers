package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Player {
    boolean turn;
    String color;
    boolean won;


    public boolean isWon() {
        return won;
    }

    public void setWon(boolean won) {
        this.won = won;
    }

    public boolean isTurn() {
        return turn;
    }

    public static boolean gameOver(ArrayList<Player> players){
        for(Player plyr : players){
            if(plyr.isWon()){
                System.out.println(plyr.isWon());
                return true;
            }
        }
        return false;
    }


    public static Player whoWon(ArrayList<Player> players){
        for(Player plyr : players){
            if(plyr.isWon()){
                return plyr;
            }
        }
        return null;
    }

    public static Player whosTurn(ArrayList<Player> players){
        for(Player plyr : players){
            if(plyr.isTurn()){
                return plyr;
            }
        }
        return null;
    }

    public static Player whosTurnIsnt(ArrayList<Player> players){
        for(Player plyr : players){
            if(!plyr.isTurn()){
                return plyr;
            }
        }
        return null;
    }

    public static void flipTurn(ArrayList<Player> players){
        for(Player plyr : players){
            if(!plyr.isTurn()){
                plyr.setTurn(true);
            }
        }
    }


    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Player(boolean turn, String color) {
        this.turn = turn;
        this.color = color;
        this.won = false;
    }
    public Player(){

    }
}