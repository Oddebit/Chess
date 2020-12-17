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
}
