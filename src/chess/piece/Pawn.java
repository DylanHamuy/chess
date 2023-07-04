package chess.piece;

import chess.board.Board;
import chess.board.Color;

public class Pawn extends Piece {

    public Pawn(){}

    public Pawn(int file, int rank, Color color) {
        _file = file;
        _rank = rank;
        _color = color;
    }

    @Override
    public boolean canMove(Board board) {
        return board.getTile(_file, _rank + 1).getPiece() == null ||
                board.getTile(_file - 1, _rank + 1).getPiece()._color != this._color ||
                board.getTile(_file + 1, _rank + 1).getPiece()._color != this._color;
    }
}
