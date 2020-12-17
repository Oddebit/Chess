package be.od.piece;

import be.od.board.Board;

import java.awt.*;

public class Queen extends Piece {
    public Queen(int x, int y, PieceColor pieceColor, Board board) {
        super(x, y, pieceColor, Type.QUEEN, board);
    }

    @Override
    public void tick() {

    }

    @Override
    public boolean canMove(int xDestination, int yDestination) {
        Piece tempPiece;

        tempPiece = new Rook(xSquare, ySquare, pieceColor, board);
        if(tempPiece.canMove(xDestination, yDestination)) return true;

        tempPiece = new Bishop(xSquare, ySquare, pieceColor, board);
        if(tempPiece.canMove(xDestination, yDestination)) return true;

        return false;
    }
}
