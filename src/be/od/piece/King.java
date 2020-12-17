package be.od.piece;

import be.od.board.Board;

import java.awt.*;

public class King extends Piece {
    public King(int x, int y, PieceColor pieceColor, Board board) {
        super(x, y, pieceColor, Type.KING, board);
    }

    @Override
    public void tick() {

    }

    @Override
    public boolean canMove(int xDestination, int yDestination) {

        int deltaX = xDestination - this.xSquare;
        int deltaY = yDestination - this.ySquare;

        if (Math.abs(deltaX) > 1 || Math.abs(deltaY) > 1) return false;
        if(isCheck(xDestination, yDestination)) return false;

        return true;
    }

    public boolean isCheck(int x, int y) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                Piece tempPiece = board.getChessBoard()[i][j];
                if(tempPiece!= null
                && tempPiece.getPieceColor() != pieceColor
                && tempPiece.canMove(x, y)) {
                    return true;
                }
            }
        }
        return false;
    }
}
