package chess.board;

import chess.piece.Piece;

public class Tile {

    private final Color COLOR;

    public Tile() {
        COLOR = null;
    }

    public Tile(int file, int rank) {
        if ((file + rank) % 2 == 0) {
            COLOR = Color.WHITE;
        } else {
            COLOR = Color.BLACK;
        }


        _hasPiece = false;
        _piece = null;
    }

    public void setPiece(Piece piece) {
        _piece = piece;
        _hasPiece = true;
    }

    public Piece getPiece() {
        return _piece;
    }

    private boolean _hasPiece;
    private Piece _piece;


}
