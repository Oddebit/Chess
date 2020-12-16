package be.od.piece;

import be.od.board.Board;
import be.od.game.Game;

import java.awt.*;

import static be.od.game.Game.*;

public abstract class Piece {
    Board board;

    PieceColor pieceColor;
    Type type;

    int x;
    int y;

    public Piece(int x, int y, PieceColor pieceColor, Type type, Board board) {
        this.pieceColor = pieceColor;
        this.x = widthMargin + x * squareSide;
        this.y = Game.REAL_HEIGHT - heightMargin - (y + 1) * squareSide;
        this.board = board;
        this.type = type;
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

    public abstract void tick();
    public void render(Graphics graphics) {

        graphics.setFont(new Font(Font.DIALOG, Font.BOLD, 30));

        if (this.pieceColor == PieceColor.WHITE) {
            graphics.setColor(new Color(0, 150, 150));
        } else {
            graphics.setColor(new Color(150, 0, 0));
        }

        int w = graphics.getFontMetrics().stringWidth(type.letter);
        int h = graphics.getFontMetrics().getHeight();

        graphics.drawString(type.letter, (int)(x + squareSide/2d - w/2d), (int)(y + squareSide/2d + h/2d));
    }

    public abstract void move(int x, int y);

    public enum PieceColor {
        BLACK,
        WHITE
    }

    public enum Type {
        PANW ("P"),
        KNIGHT ("N"),
        BISHOP ("B"),
        ROOK ("R"),
        QUEEN ("Q"),
        KING ("K");

        String letter;

        Type(String letter) {
            this.letter = letter;
        }
    }
}
