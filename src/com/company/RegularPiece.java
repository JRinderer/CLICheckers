package com.company;

public class RegularPiece implements Piece {
    //Fixing git
    //an empty piece is red is 1 white 2
    String color;
    int xCord;
    int yCord;
    String name;
    String fullName;
    int forwrdMove;
    int jumpMove;
    int id;
    int status;
    int kingRow;
    public static int counter=0;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getKingRow() {
        return kingRow;
    }

    public void setKingRow(int kingRow) {
        this.kingRow = kingRow;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getJumpMove() {
        return jumpMove;
    }

    public void setJumpMove(int jumpMove) {
        this.jumpMove = jumpMove;
    }

    public String getColor() {
        return color;
    }

    public int getForwrdMove() {
        return forwrdMove;
    }

    public void setForwrdMove(int forwrdMove) {
        this.forwrdMove = forwrdMove;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getxCord() {
        return xCord;
    }

    public void setxCord(int xCord) {
        this.xCord = xCord;
    }

    public int getyCord() {
        return yCord;
    }

    public void setyCord(int yCord) {
        this.yCord = yCord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }

    public RegularPiece(String col, int forwrdMove, int jumpMove){
        this.color=col;
        this.setId(counter);
        this.forwrdMove = forwrdMove;
        this.jumpMove = jumpMove;
        this.status=1;
        if(col.equals("R")){
            this.kingRow = 7;
        }else{
            this.kingRow = 0;
        }
        counter++;

    }

    public RegularPiece(){
        this.setId(counter);
        counter++;
    }

    public void convertToKing(){

    }

    public boolean isJump(Piece self,int x, int y){

        return true;
    }
}
