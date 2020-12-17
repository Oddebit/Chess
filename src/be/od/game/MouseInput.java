package be.od.game;

import be.od.board.Board;
import be.od.piece.Piece;

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

        if (0 > xPiece || xPiece > 7) return;
        if (0 > yPiece || yPiece > 7) return;

        Piece destination = board.getChessBoard()[xPiece][yPiece];

        // if there is a selected piece
        if(selectedPiece != null) {

            //if i click on the same piece again
            if(destination == selectedPiece) {
                //unselect it
                selectedPiece.setSelected(false);
                selectedPiece = null;
            //if i click on a piece that has the same color
            } else if(destination != null && selectedPiece.getPieceColor() == destination.getPieceColor()) {
                //select the new piece
                selectedPiece.setSelected(false);
                destination.setSelected(true);
                selectedPiece = destination;
            } else {
                //move the piece to the pointed square
                if(selectedPiece.canMove(xPiece, yPiece)) {
                    selectedPiece.move(xPiece, yPiece);
                    selectedPiece.setSelected(false);
                    selectedPiece = null;
                }

            }

        } else {
            //select the piece
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
