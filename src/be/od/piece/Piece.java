package be.od.piece;

import be.od.board.Board;

public abstract class Piece {

    PieceColor pieceColor;
    Board board;
    int x;
    int y;

    public Piece(int x, int y, PieceColor pieceColor, Board board) {
        this.pieceColor = pieceColor;
        this.x = x;
        this.y = y;
        this.board = board;
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public void setPieceColor(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public abstract void move(int x, int y);

    public enum PieceColor {
        BLACK,
        WHITE
    }
}
