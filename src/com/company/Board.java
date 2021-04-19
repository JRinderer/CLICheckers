package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Board {
    //Fixing git
    ArrayList<RegularPiece> redPieces = new ArrayList<RegularPiece>();
    ArrayList<RegularPiece> whitePieces = new ArrayList<RegularPiece>();

    Square[][] squares = new Square[8][8];

    public Board() {
        this.setBoard();
    }


    public void setBoard() {

        //we need to create squares in an 8x8 grade
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                squares[x][y] = new Square();
            }
        }

        //with empty squares created we can begin adding pieces row by row.
        //create 12 red pieces
        ArrayList<RegularPiece> tempList = new ArrayList<>();
        for (int x = 0; x < 8; x++) {
            switch (x) {
                case 0:
                    setEvenCols(x, redPieces, "R",-1, -2);
                    break;
                case 1:
                    setOddCols(x,redPieces,"R",-1, -2);
                    break;
                case 2:
                    setEvenCols(x,redPieces,"R",-1, -2);

                    break;
                case 3: //empty rows
                    sentAllBlank(x);
                    break;
                case 4: //empty rows
                    sentAllBlank(x);
                    break;
                case 5: //white rows
                    setOddCols(x, whitePieces,"W",1, 2);
                    break;
                case 6: //white rows
                    setEvenCols(x,whitePieces,"W",1,2);
                    break;
                case 7: //white rows
                    setOddCols(x, whitePieces,"W",1,2);
                    break;
            }
        }
    }

    public void setOddCols(int row, ArrayList<RegularPiece> pieces, String color, int move, int jump) {
        int pieceCounter = 0;
        for(int y = 0;y<8;y++){
            if(y%2==0){
                RegularPiece thisPiece = new RegularPiece(color,move,jump);
                setPieceOnSpace(thisPiece,row,y);
                thisPiece.setName("__"+ color +  row + "-" + y + "_" );
                thisPiece.setFullName(color + row + "-" + y);
                thisPiece.setxCord(row);
                thisPiece.setyCord(y);
                pieces.add(thisPiece);
            }
            else{
                RegularPiece emptyPiece = new RegularPiece("",0,0);
                setPieceOnSpace(emptyPiece,row,y);
                emptyPiece.setName("__" + row + "-" + y + "__");
                emptyPiece.setFullName("empty");
            }

        }
    }

    public void sentAllBlank(int row){
        for (int y=0;y<8;y++){
            RegularPiece emptyPiece = new RegularPiece("",0,0);
            setPieceOnSpace(emptyPiece,row,y);
            emptyPiece.setName("__" + row + "-" + y + "__");
            emptyPiece.setFullName("empty");
        }
    }


    public void setEvenCols(int row,ArrayList<RegularPiece> pieces, String color, int move, int jump) {
        int pieceCounter = 0;
        for(int y = 0;y<8;y++){
            if(y%2!=0){
                RegularPiece thisPiece = new RegularPiece(color,move, jump);
                setPieceOnSpace(thisPiece,row,y);
                thisPiece.setName("__"+ color +  row + "-" + y + "_" );
                thisPiece.setFullName(color + row + "-" + y);
                thisPiece.setxCord(row);
                thisPiece.setyCord(y);
                pieces.add(thisPiece);
            }
            else{
                RegularPiece emptyPiece = new RegularPiece("",0,0);
                setPieceOnSpace(emptyPiece,row,y);
                emptyPiece.setName("__" + row + "-" + y + "__");
                emptyPiece.setFullName("empty");
            }

        }
    }

    public Piece findPiece(String name, Player player) throws InterruptedException {
        ArrayList<Piece> myLIst = new ArrayList<>();
        myLIst = this.getPieces();
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

    public ArrayList<Piece> showBoard() {
        //print first row
        ArrayList<Piece> tempList = new ArrayList<>();
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                System.out.print(squares[x][y].getPieceName());
                tempList.add(squares[x][y].getPiece());
            }
            System.out.println();
        }
        return tempList;
    }
    //

    public void setPieceOnSpace(Piece piece, int x, int y ) {

        squares[x][y].setPiece(piece);
    }

    public void removePieceOnSpace(int x, int y){
        RegularPiece emptyPiece = new RegularPiece("",0,0);
        emptyPiece.setName("__"+x+"-"+y+"__");
        emptyPiece.setFullName("empty");
        squares[x][y].setPiece(emptyPiece);
    }


    public ArrayList<Piece> getPieces() {
        ArrayList<Piece> tempList = new ArrayList<>();
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                tempList.add(squares[x][y].getPiece());
            }
        }
        return tempList;
    }

}
