package be.od.piece;

import be.od.board.Board;

public class Rook extends Piece {

    public Rook(int x, int y, PieceColor pieceColor, Board board) {
        super(x, y, pieceColor, board);
    }

    @Override
    public void move(int x, int y) {
        if ((x != this.x && y != this.y)|| (x == this.x && y == this.y)) return;
        if (x == this.x){
            for (int i = Math.min(x, this.x) + 1; i < Math.max(x, this.x) - 1; i++) {
                if(board.getChessBoard()[x][i] != null) return;
            }
        } else {
            for (int i = Math.min(y, this.y) + 1; i < Math.max(y, this.y) - 1; i++) {
                if(board.getChessBoard()[i][y] != null) return;
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
