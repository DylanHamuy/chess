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
        // Set up pawns
        int[] pawnRanks = {1, 6};
        for (int rank : pawnRanks) {
            for (int file = 0; file < Board.SIDE; file++) {
                _board.getTile(file, rank).setPiece(new Pawn());
            }
        }

        // Set up pieces
        int[] pieceRank = {0, 7};
        PieceType[] pieces = {PieceType.ROOK, PieceType.KNIGHT, PieceType.BISHOP, PieceType.QUEEN, PieceType.KING,
                                PieceType.BISHOP, PieceType.KNIGHT, PieceType.ROOK};
        for (int rank : pieceRank) {
            for (int file = 0; file < Board.SIDE; file++) {
                PieceType pieceType = pieces[file];
                Piece piece;

                switch (pieceType) {
                    case ROOK:
                        piece = new Rook();
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

    public Board getBoard(){
        return _board;
    }

    private Board _board;
}
