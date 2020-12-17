package be.od.board;

import be.od.game.Game;
import be.od.piece.*;

import java.awt.*;

import static be.od.game.Game.*;

public class Board extends Canvas {

    private Piece[][] chessBoard = new Piece[8][8];

    public Board(){
        addPieces();
    }
    public void addPieces(){

        for (Piece[] row : chessBoard) {
            for (Piece piece : row) {
                piece = null;
            }
        }

        chessBoard[0][0] = new Rook(0,0, Piece.PieceColor.WHITE, this);
        chessBoard[1][0] = new Knight(1,0, Piece.PieceColor.WHITE, this);
        chessBoard[2][0] = new Bishop(2,0, Piece.PieceColor.WHITE, this);
        chessBoard[3][0] = new Queen(3,0, Piece.PieceColor.WHITE, this);
        chessBoard[4][0] = new King(4,0, Piece.PieceColor.WHITE, this);
        chessBoard[5][0] = new Bishop(5,0, Piece.PieceColor.WHITE, this);
        chessBoard[6][0] = new Knight(6,0, Piece.PieceColor.WHITE, this);
        chessBoard[7][0] = new Rook(7,0, Piece.PieceColor.WHITE, this);
        chessBoard[0][1] = new Pawn(0,1, Piece.PieceColor.WHITE, this);
        chessBoard[1][1] = new Pawn(1,1, Piece.PieceColor.WHITE, this);
        chessBoard[2][1] = new Pawn(2,1, Piece.PieceColor.WHITE, this);
        chessBoard[3][1] = new Pawn(3,1, Piece.PieceColor.WHITE, this);
        chessBoard[4][1] = new Pawn(4,1, Piece.PieceColor.WHITE, this);
        chessBoard[5][1] = new Pawn(5,1, Piece.PieceColor.WHITE, this);
        chessBoard[6][1] = new Pawn(6,1, Piece.PieceColor.WHITE, this);
        chessBoard[7][1] = new Pawn(7,1, Piece.PieceColor.WHITE, this);

        chessBoard[0][7] = new Rook(0,7, Piece.PieceColor.BLACK, this);
        chessBoard[1][7] = new Knight(1,7, Piece.PieceColor.BLACK, this);
        chessBoard[2][7] = new Bishop(2,7, Piece.PieceColor.BLACK, this);
        chessBoard[3][7] = new Queen(3,7, Piece.PieceColor.BLACK, this);
        chessBoard[4][7] = new King(4,7, Piece.PieceColor.BLACK, this);
        chessBoard[5][7] = new Bishop(5,7, Piece.PieceColor.BLACK, this);
        chessBoard[6][7] = new Knight(6,7, Piece.PieceColor.BLACK, this);
        chessBoard[7][7] = new Rook(7,7, Piece.PieceColor.BLACK, this);
        chessBoard[0][6] = new Pawn(0,6, Piece.PieceColor.BLACK, this);
        chessBoard[1][6] = new Pawn(1,6, Piece.PieceColor.BLACK, this);
        chessBoard[2][6] = new Pawn(2,6, Piece.PieceColor.BLACK, this);
        chessBoard[3][6] = new Pawn(3,6, Piece.PieceColor.BLACK, this);
        chessBoard[4][6] = new Pawn(4,6, Piece.PieceColor.BLACK, this);
        chessBoard[5][6] = new Pawn(5,6, Piece.PieceColor.BLACK, this);
        chessBoard[6][6] = new Pawn(6,6, Piece.PieceColor.BLACK, this);
        chessBoard[7][6] = new Pawn(7,6, Piece.PieceColor.BLACK, this);


    }

    public void render(Graphics graphics) {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    graphics.setColor(Color.black);
                } else {
                    graphics.setColor(Color.white);
                }

                graphics.fillRect(widthMargin + i * squareSide,
                                Game.REAL_HEIGHT - heightMargin - (j + 1) * squareSide,
                                    squareSide, squareSide);
                Piece tempPiece = chessBoard[i][j];
                if(tempPiece != null) {
                    chessBoard[i][j].render(graphics);
                }
            }
        }
    }

    public void tick() {
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
//                Piece tempPiece = chessBoard[i][j];
//                if(tempPiece != null) {
//                    chessBoard[i][j].tick();
//                }
//            }
//        }
    }

    public Piece[][] getChessBoard() {
        return chessBoard;
    }

    public void setPiecePosition(Piece piece, int x, int y) {
        chessBoard[x][y] = piece;
    }
}
