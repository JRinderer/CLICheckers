package com.company;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {
    boolean over;
    Board board;
    Player redPlayer;
    Player whitePlayer;
    ArrayList<Piece> currentPieces = new ArrayList<>();
    Scanner myScanner = new Scanner(System.in);
    String cont="y";
    int x;
    int y;
    String pieceName;
    Piece piece = new RegularPiece();;
    Player currentPlayerHolder = new Player();
    Player oppositePlayerHolder = new Player();

    //setup procedures
    private void setUpGame(){
        createBoard();
        createPlayers();
        createScanner();
    }

    private void createPlayers(){
        //setup players red goes first
        this.redPlayer = new Player(true, "R");
        this.whitePlayer = new Player(false, "W");
    }

    private void createScanner(){
        this.myScanner = new Scanner(System.in);
    }

    private void createBoard(){
        this.board = new Board();
    }
    //end od setup procedures


    //methods to play the game


    //

    //this is our main function for playing the game
    private void playGame() throws InterruptedException {
        //setup an arrayList of all the pieces currently on the board
        //setup a scanner to get input

        /*
        setUpGame sets up the:
            Board
            Players
            and creates the scanner
         */
        this.setUpGame();

        this.setOver(true);
        //this is local to the Play game
        boolean canMove;

        this.currentPieces = this.board.showBoard();

        //create an array list and store our players
        ArrayList<Player> players = new ArrayList<>();
        players.add(this.redPlayer);
        players.add(this.whitePlayer);

        //create a holder for the current player


        //ask if Red wants to surrender
        System.out.println("Would you like to surrender?");
       this.cont = this.myScanner.nextLine();

        //if the user wants to surrender we can exit
        if (this.cont.equals("y")) {
            this.redPlayer.setWon(false);
            this.redPlayer.setWon(true);
            this.setOver(true);
        }else{
            this.setOver(false);
        }

        //while the game isn't over we keep playing
        while (!this.isOver()) {//this.cont.equals("n") && (!Player.gameOver(players))) {
            //determine what players turn it is
            Player.gameOver(players);

            this.currentPlayerHolder = Player.whosTurn(players);
            this.oppositePlayerHolder = Player.whosTurnIsnt(players);

            System.out.println("Type a piece name:");
            this.pieceName = this.myScanner.nextLine();
            this.piece = this.board.findPiece(this.pieceName, this.currentPlayerHolder);

            //make sure the user types in a valid pieces
            while (Objects.isNull(this.piece)) {
                System.out.println("Type a piece name:");
                this.pieceName = this.myScanner.nextLine();
                this.piece = this.board.findPiece(this.pieceName, this.currentPlayerHolder);
            }
            //try to get numeric input from our users
            try {
                System.out.println("Enter the X coordinates to move the piece:");
                this.x = this.myScanner.nextInt();
                System.out.println("Enter the Y Coordinates to move the piece:");
                this.y = this.myScanner.nextInt();
                this.myScanner.nextLine();
                canMove = this.piece.move(this.board, this.x, this.y, this.currentPlayerHolder);
                //if this is not a valid move ask the user to try agian
                if (!canMove) {
                    System.out.println("Invalid move. Please try again!");
                    TimeUnit.SECONDS.sleep(1);
                //if the move is valid we can swap turns
                } else {
                    Player.flipTurn(players);
                    this.currentPlayerHolder.setTurn(false);
                }
            //this prints if the dat the user enters isn't an integer
            } catch (Exception ex) {
                System.out.println("Expected an integers for x ad y. Try again");
                TimeUnit.SECONDS.sleep(1);

            }
            //after the move is made show the board
            this.currentPieces = this.board.showBoard();
            //
            System.out.println("Would you like to surrender?");
            //myScanner.nextLine();
            this.cont = this.myScanner.nextLine();

            if (this.cont.equals("y")) {
                this.setOver(true);
                System.out.println(this.currentPlayerHolder.getColor());
                System.out.println(this.oppositePlayerHolder.getColor());
                this.currentPlayerHolder.setWon(true);
                this.oppositePlayerHolder.setWon(false);
            }

            ArrayList<Piece> runningPieces = this.board.getPieces();
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
                this.setOver(true);
                redPlayer.setWon(false);
                whitePlayer.setWon(true);
            } else if (whiteCounter == 0) {
                this.setOver(true);
                whitePlayer.setWon(false);
                redPlayer.setWon(true);
            }

        }

        if (this.redPlayer.isWon()) {
            System.out.println("Red Won");
        } else if (this.whitePlayer.isWon()) {
            System.out.println("White Won");
        } else {
            System.out.println("I have no idea what happened");
        }
    }

    private boolean isOver() {
        return over;
    }

    private void setOver(boolean over) {
        this.over = over;
    }

    public Game() throws InterruptedException {
        this.over = false;
        this.playGame();
    }
}