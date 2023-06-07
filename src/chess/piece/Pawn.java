package chess.piece;

import chess.board.Board;

public class Pawn extends Piece {

    @Override
    public void move(int file, int rank) {

    }

    @Override
    public boolean canMove(Board board) {
        return false;
    }

}
