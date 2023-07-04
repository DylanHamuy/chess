import chess.board.Board;
import chess.board.Color;
import chess.board.PieceType;
import chess.piece.*;

public class Game {

    public Game() {
        newGame();
    }

    public void newGame () {
        _board = new Board();
        setupPieces();
    }

    public void setupPieces() {
        Color pieceColor;
        // Set up pawns
        int[] pawnRanks = {1, 6};
        for (int rank : pawnRanks) {
            if (rank == 1) {
                pieceColor = Color.WHITE;
            } else {
                pieceColor = Color.BLACK;
            }
            for (int file = 0; file < Board.SIDE; file++) {
                _board.getTile(file, rank).setPiece(new Pawn(file, rank, pieceColor));
            }
        }

        // Set up pieces
        int[] pieceRank = {0, 7};
        PieceType[] pieces = {PieceType.ROOK, PieceType.KNIGHT, PieceType.BISHOP, PieceType.QUEEN, PieceType.KING,
                                PieceType.BISHOP, PieceType.KNIGHT, PieceType.ROOK};
        for (int rank : pieceRank) {
            if (rank == 0) {
                pieceColor = Color.WHITE;
            } else {
                pieceColor = Color.BLACK;
            }
            for (int file = 0; file < Board.SIDE; file++) {
                PieceType pieceType = pieces[file];
                Piece piece;

                switch (pieceType) {
                    case ROOK:
                        piece = new Rook(file, rank, pieceColor);
                        break;
                    case KNIGHT:
                        piece = new Knight();
                        break;
                    case BISHOP:
                        piece = new Bishop();
                        break;
                    case QUEEN:
                        piece = new Queen();
                        break;
                    case KING:
                        piece = new King();
                        break;
                    default:
                        piece = null;
                        break;
                }
                _board.getTile(file, rank).setPiece(piece);
            }
        }
    }

    public void move(int origFile, int origRank, int destFile, int destRank) {
        Piece piece = _board.getTile(origFile, origRank).getPiece();
        _board.getTile(origFile, origRank).setPiece(null);

        _board.getTile(destFile, destRank).setPiece(piece);
    }

    public Board getBoard(){
        return _board;
    }

    private Board _board;
}
