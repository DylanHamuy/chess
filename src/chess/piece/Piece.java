package chess.piece;

import chess.board.Board;

public abstract class Piece {

    public abstract void move(int file, int rank);
    public abstract boolean canMove(Board board);


    protected int _file;
    protected int _rank;

}