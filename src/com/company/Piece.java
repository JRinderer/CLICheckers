package com.company;

public interface Piece {
    //Fixing git
    //public boolean move(Board board, int x, int y, Player player); //commented out until we start work on Pieces.
    public boolean isJump(Piece pce, int x, int y);
    public String getName();
    public void setName(String name);
    public int getId();
    public int getxCord();
    public void setxCord(int xCord);
    public void setyCord(int yCord);
    public int getyCord();
    public String getColor();
    public int getForwrdMove();
    public int getJumpMove();
    public int getStatus();
    public void setStatus(int status);
    public void setKingRow(int kingRow);
    public int getKingRow();
    public void setFullName(String fullName);
    public String getFullName();
    //

}
