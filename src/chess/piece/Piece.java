package chess.piece;

import chess.board.Board;
import chess.board.Color;

public abstract class Piece {

    public abstract boolean canMove(Board board);


    protected int _file;
    protected int _rank;
    protected Color _color;

}