package be.od.piece;

import be.od.board.Board;

public class Bishop extends Piece {

    public Bishop(int x, int y, PieceColor pieceColor, Board board) {
        super(x, y, pieceColor, Type.BISHOP, board);
    }

    @Override
    public void tick() {

    }

    @Override
    public boolean canMove(int xDestination, int yDestination) {

        int deltaX = xDestination - this.xSquare;
        int deltaY = yDestination - this.ySquare;

        if (Math.abs(deltaX) != Math.abs(deltaY)) return false;
        if (Math.abs(deltaX) == 1) return true;

        int iterator;
        if (this.xSquare < xDestination) {
            iterator = 1;
        } else {
            iterator = -1;
        }

        if (deltaX == deltaY) {
            // "/" diagonal

            for (int i = iterator; Math.abs(i) < Math.abs(deltaX); i += iterator) {
                if (board.getChessBoard()[this.xSquare + i][this.ySquare + i] != null) return false;
            }

        } else {
            // "\" diagonal

            for (int i = iterator; Math.abs(i) < Math.abs(deltaX); i += iterator) {
                if (board.getChessBoard()[this.xSquare + i][this.ySquare - i] != null) return false;
            }
        }

        return true;
    }
}
