package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static Piece findPiece(String name, Board board, Player player) throws InterruptedException {
        ArrayList<Piece> myLIst = new ArrayList<>();
        myLIst = board.getPieces();
        for (Piece piece : myLIst) {
            //validate that the piece name exists, and that the color is the same as the players
            if (Objects.isNull(piece.getFullName())) {
                System.out.println(piece.getName());
            }
            if (piece.getFullName().equals(name) && player.getColor().equals(piece.getColor())) {
                return piece;
            }
        }
        System.out.println("The piece doesn't exist, or the players color doesn't match the piece selected. Try again");
        TimeUnit.SECONDS.sleep(1);
        return null;
    }

    //Fixing git
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Piece> currentPieces = new ArrayList<>();
        Scanner myScanner = new Scanner(System.in);
        Board myBoard = new Board();
        Game thisGame = new Game();
        myBoard.removePieceOnSpace(0,1);
        myBoard.removePieceOnSpace(0,3);
        myBoard.removePieceOnSpace(0,5);
        myBoard.removePieceOnSpace(0,7);
        myBoard.removePieceOnSpace(1,0);
        myBoard.removePieceOnSpace(1,2);
        myBoard.removePieceOnSpace(1,4);
        myBoard.removePieceOnSpace(1,6);
        myBoard.removePieceOnSpace(2,1);
        myBoard.removePieceOnSpace(2,4);
        myBoard.removePieceOnSpace(2,5);
        myBoard.removePieceOnSpace(2,7);
        thisGame.setOver(true);

        String cont = "y";
        String pieceName;
        int x;
        int y;

        Piece piece = new RegularPiece();
        boolean canMove;

        currentPieces = myBoard.showBoard();

        //setup players red goes first
        Player redPlayer = new Player(true, "R");
        Player whitePlayer = new Player(false, "W");
        //create an array list and store our players
        ArrayList<Player> players = new ArrayList<>();
        players.add(redPlayer);
        players.add(whitePlayer);

        //create a holder for the current player
        Player currentPlayerHolder = new Player();
        Player oppositePlayerHolder = new Player();

        System.out.println("Would you like to surrender?");
        cont = myScanner.nextLine();

        if (cont.equals("y")) {
            redPlayer.setWon(false);
            whitePlayer.setWon(true);
            thisGame.setOver(true);
        }else{
            thisGame.setOver(false);
        }

        while (!thisGame.isOver()) {//cont.equals("n") && (!Player.gameOver(players))) {
            //determine what players turn it is
            Player.gameOver(players);

            currentPlayerHolder = Player.whosTurn(players);
            oppositePlayerHolder = Player.whosTurnIsnt(players);

            System.out.println("Type a piece name:");
            pieceName = myScanner.nextLine();
            piece = findPiece(pieceName, myBoard, currentPlayerHolder);

            while (Objects.isNull(piece)) {
                System.out.println("Type a piece name:");
                pieceName = myScanner.nextLine();
                piece = findPiece(pieceName, myBoard, currentPlayerHolder);
            }
            //added
            try {
                System.out.println("Enter the X coordinates to move the piece:");
                x = myScanner.nextInt();
                System.out.println("Enter the Y Coordinates to move the piece:");
                y = myScanner.nextInt();
                myScanner.nextLine();
                canMove = piece.move(myBoard, x, y, currentPlayerHolder);
                if (!canMove) {
                    System.out.println("Invalid move. Please try again!");
                    TimeUnit.SECONDS.sleep(1);
                } else {
                    Player.flipTurn(players);
                    currentPlayerHolder.setTurn(false);
                }
            } catch (Exception ex) {
                System.out.println("Expected an integers for x ad y. Try again");
                TimeUnit.SECONDS.sleep(1);

            }

            currentPieces = myBoard.showBoard();
            System.out.println("Would you like to surrender?");
            //myScanner.nextLine();
            cont = myScanner.nextLine();

            if (cont.equals("y")) {
                thisGame.setOver(true);
                System.out.println(currentPlayerHolder.getColor());
                System.out.println(oppositePlayerHolder.getColor());
                currentPlayerHolder.setWon(true);
                oppositePlayerHolder.setWon(false);
            }

            ArrayList<Piece> runningPieces = myBoard.getPieces();
            int redCounter = 0;
            int whiteCounter = 0;

            for (Piece p : runningPieces) {
                if (p.getColor().equals("R")) {
                    redCounter++;
                } else if (p.getColor().equals("W")) {
                    whiteCounter++;
                }
            }

            if (redCounter == 0) {
                thisGame.setOver(true);
                redPlayer.setWon(false);
                whitePlayer.setWon(true);
            } else if (whiteCounter == 0) {
                thisGame.setOver(true);
                whitePlayer.setWon(false);
                redPlayer.setWon(true);
            }

        }

        if (redPlayer.isWon()) {
            System.out.println("Red Won");
        } else if (whitePlayer.isWon()) {
            System.out.println("White Won");
        } else {
            System.out.println("I have no idea what happened");
        }
    }
}