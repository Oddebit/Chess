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
}
