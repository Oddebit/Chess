package be.od.piece;

import be.od.board.Board;

public class Bishop extends Piece{

    public Bishop(int x, int y, PieceColor pieceColor, Board board) {
        super(x, y, pieceColor, board);
    }

    @Override
    public void move(int x, int y) {

        int deltaX = this.x - x;
        int deltaY = this.y - y;

        if ((Math.abs(deltaX) != Math.abs(deltaY))|| (x == this.x && y == this.y)) return;
        if (deltaX == deltaY){
            for (int i = Math.min(x, this.x) + 1; i < Math.max(x, this.x) - 1; i++) {
                for (int j = Math.min(y, this.y) + 1; j < Math.max(y, this.y) - 1; j++) {
                    if(board.getChessBoard()[j][i] != null) return;
                }
            }
        } else {
            for (int i = Math.min(x, this.x) + 1; i < Math.max(x, this.x) - 1; i++) {
                for (int j = Math.max(y, this.y) + 1; j < Math.min(y, this.y) - 1; j--) {
                    if(board.getChessBoard()[j][i] != null) return;
                }
            }
        }

        if(board.getChessBoard()[x][y] == null || board.getChessBoard()[x][y].getPieceColor() != pieceColor) {
            board.setPiecePosition(null, this.x, this.y);
            board.setPiecePosition(this, x, y);
            this.x = x;
            this.y = y;
        }
    }
}
