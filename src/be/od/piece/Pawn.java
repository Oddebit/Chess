package be.od.piece;

import be.od.board.Board;

import java.awt.*;

public class Pawn extends Piece{
    public Pawn(int x, int y, PieceColor pieceColor, Board board) {
        super(x, y, pieceColor, Type.PANW, board);
    }

    @Override
    public void tick() {

    }

    @Override
    public void move(int x, int y) {

    }
}
