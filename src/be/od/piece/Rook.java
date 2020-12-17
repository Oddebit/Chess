package be.od.piece;

import be.od.board.Board;
import be.od.game.Game;

import java.awt.*;

import static be.od.game.Game.*;
import static be.od.game.Game.squareSide;

public class Rook extends Piece {

    public Rook(int x, int y, PieceColor pieceColor, Board board) {
        super(x, y, pieceColor, Type.ROOK, board);
    }

    @Override
    public void tick() {

    }

    @Override
    public boolean canMove(int xSquare, int ySquare) {

        //only vertical and horizontal
        if (xSquare != this.xSquare && ySquare != this.ySquare) return false;

        int deltaX = Math.abs(this.xSquare - xSquare);
        int deltaY = Math.abs(this.ySquare - ySquare);

        if(this.xSquare == xSquare && deltaY != 1) {
            for (int i = Math.min(this.ySquare, ySquare) + 1; i < Math.max(this.ySquare, ySquare); i++) {
                if (board.getChessBoard()[this.xSquare][i] != null) return false;
            }

        } else if(this.ySquare == ySquare && deltaX != 1) {
            for (int i = Math.min(this.xSquare, xSquare) + 1; i < Math.max(this.xSquare, xSquare); i++) {
                if (board.getChessBoard()[i][this.ySquare] != null) return false;
            }
        }

        return true;
    }
}
