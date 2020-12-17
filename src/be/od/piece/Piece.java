package be.od.piece;

import be.od.board.Board;
import be.od.game.Game;

import java.awt.*;

import static be.od.game.Game.*;

public abstract class Piece {
    protected Board board;

    protected PieceColor pieceColor;
    protected Type type;

    protected int x;
    protected int y;

    protected int xSquare;
    protected int ySquare;

    protected boolean isSelected;

    public Piece(int x, int y, PieceColor pieceColor, Type type, Board board) {
        this.pieceColor = pieceColor;

        this.x = widthMargin + x * squareSide;
        this.y = Game.REAL_HEIGHT - heightMargin - (y + 1) * squareSide;

        this.xSquare = x;
        this.ySquare = y;

        this.board = board;
        this.type = type;
        this.isSelected = false;
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public int getX() {
        return xSquare;
    }

    public void setX(int x) {
        this.xSquare = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Type getType() {
        return type;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public abstract void tick();

    public void render(Graphics graphics) {

        graphics.setFont(new Font(Font.DIALOG, Font.BOLD, 30));

        int lighter = 0;
        if (isSelected) lighter = 50;
            if (this.pieceColor == PieceColor.WHITE) {
                graphics.setColor(new Color(0, 150 + lighter, 150 + lighter));
            } else {
                graphics.setColor(new Color(150 + lighter, 0, 0));
            }

        int w = graphics.getFontMetrics().stringWidth(type.letter);
        int h = graphics.getFontMetrics().getHeight();

        graphics.drawString(type.letter, (int) (x + squareSide / 2d - w / 2d), (int) (y + squareSide / 2d + h / 2d));
    }

    public boolean canMove(int xSquare, int ySquare) {
        return true;
    }

    public void move(int xSquare, int ySquare) {
        board.setPiecePosition(null, this.xSquare, this.ySquare);
        board.setPiecePosition(this, xSquare, ySquare);
        this.xSquare = xSquare;
        this.ySquare = ySquare;
        this.x = widthMargin + xSquare * squareSide;
        this.y = Game.REAL_HEIGHT - heightMargin - (ySquare + 1) * squareSide;
    }

    public enum PieceColor {
        BLACK,
        WHITE
    }

    public enum Type {
        PANW("P"),
        KNIGHT("N"),
        BISHOP("B"),
        ROOK("R"),
        QUEEN("Q"),
        KING("K");

        String letter;

        Type(String letter) {
            this.letter = letter;
        }
    }
}
