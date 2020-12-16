package be.od.game;

import be.od.board.Board;
import be.od.piece.Piece;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static be.od.game.Game.*;

public class MouseInput extends MouseAdapter {

    private final Board board;
    private Piece selectedPiece;

    int xPiece;
    int yPiece;

    public MouseInput(Board board) {
        this.board = board;
    }

    public void mouseClicked(MouseEvent e) {
        xPiece = (e.getX() - widthMargin) / squareSide + 1;
        yPiece = (e.getY() - REAL_HEIGHT + heightMargin) / squareSide;

        Piece tempPiece = board.getChessBoard()[xPiece][yPiece];
        if(tempPiece != null) {
            selectedPiece.setSelected(false);
            tempPiece.setSelected(true);
            selectedPiece = tempPiece;
        }


    }

    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        xPiece = (e.getX() - widthMargin) / squareSide + 1;
        yPiece = (e.getY() - REAL_HEIGHT + heightMargin) / squareSide;
    }

    public void render(Graphics graphics) {
        graphics.setColor(Color.black);
        graphics.setFont(new Font(Font.DIALOG, 0, 12));
        graphics.drawString(String.valueOf(xPiece), 5, 15);
        graphics.drawString(String.valueOf(yPiece), 5, 30);
    }
}
