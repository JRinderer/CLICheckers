package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    //Broken_Checkers_For_Class_To_Fix
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Piece> currentPieces = new ArrayList<>();
        Scanner myScanner = new Scanner(System.in);
        Board myBoard = new Board();
        ArrayList<Piece> pieces = new ArrayList<>();
        pieces = myBoard.showBoard();

        //I am picking up piece R0-1 and moving it to square 3-1
        myBoard.setPieceOnSpace(pieces.get(1),3,1);
        System.out.println("=======================NEW BOARD=======================");
        //I am removing piece R0-1 from it's original position at 0,1)
        myBoard.removePieceOnSpace(0,1);
        //The board will display R0-1 on it's new square
        pieces = myBoard.showBoard();




    }
}