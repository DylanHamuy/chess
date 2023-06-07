package chess.piece;

public abstract class Piece {

    public abstract void move(int file, int rank);
    public abstract boolean canMove();


    protected int _file;
    protected int _rank;

}