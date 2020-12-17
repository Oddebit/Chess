package be.od.piece;

import be.od.board.Board;

import java.awt.*;

public class Pawn extends Piece{

    boolean hasMoved;
    public Pawn(int x, int y, PieceColor pieceColor, Board board) {
        super(x, y, pieceColor, Type.PANW, board);
        this.hasMoved = false;
    }

    @Override
    public void tick() {

    }

    @Override
    public boolean canMove(int xDestination, int yDestination) {

        int direction = pieceColor == PieceColor.WHITE ? 1 : -1;

        int deltaX = (xDestination - this.xSquare) * direction;
        int deltaY = (yDestination - this.ySquare) * direction;



        if(deltaX != 0) return false;
        if(deltaY < 0) return false;
        if(hasMoved && deltaY > 1) return false;
        if(!hasMoved && deltaY > 2) return false;

        hasMoved = true;
        return true;
    }
}
