package chess.piece;

import chess.board.Board;
import chess.board.Color;

public class Rook extends Piece {

    public Rook(int file, int rank, Color color) {
        _file = file;
        _rank = rank;
        _color = color;
    }

    @Override
    public void move(int file, int rank) {

    }

    @Override
    public boolean canMove(Board board) {
        return false;
    }


}
