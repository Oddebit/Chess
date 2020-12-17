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

    @Override
    public void mouseClicked(MouseEvent e) {
        xPiece = (e.getX() - widthMargin) / squareSide;
        yPiece = -(e.getY() - REAL_HEIGHT + heightMargin) / squareSide;

        Piece destination = board.getChessBoard()[xPiece][yPiece];

        if(selectedPiece != null) {
            if(destination == selectedPiece) {
                selectedPiece.setSelected(false);
                selectedPiece = null;
            } else if(destination != null && selectedPiece.getPieceColor() == destination.getPieceColor()) {
                selectedPiece.setSelected(false);
                destination.setSelected(true);
                selectedPiece = destination;
            } else {
                selectedPiece.move(xPiece, yPiece);
                selectedPiece.setSelected(false);
                selectedPiece = null;
            }

        } else {
            if(destination != null) {
                selectedPiece = destination;
                destination.setSelected(true);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        xPiece = (e.getX() - widthMargin) / squareSide;
        yPiece = -( (e.getY() - REAL_HEIGHT + heightMargin) / squareSide );
    }
}
