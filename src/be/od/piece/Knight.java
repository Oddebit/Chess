package be.od.piece;

import be.od.board.Board;

import java.awt.*;

public class Knight extends Piece{
    public Knight(int x, int y, PieceColor pieceColor, Board board) {
        super(x, y, pieceColor, Type.KNIGHT, board);
    }

    @Override
    public void tick() {

    }

    @Override
    public boolean canMove(int xDestination, int yDestination) {

        int deltaX = xDestination - this.xSquare;
        int deltaY = yDestination - this.ySquare;

        if(Math.abs(deltaX) == 2 && Math.abs(deltaY) == 1) return true;
        if(Math.abs(deltaX) == 1 && Math.abs(deltaY) == 2) return true;

        return false;
    }
}
