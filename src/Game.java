import chess.board.Board;
import chess.board.Color;
import chess.board.PieceType;
import chess.piece.*;

public class Game {

    /**
     * Constructs a new Game object and starts a new game.
     */
    public Game() {
        newGame();
    }

    /**
     * Starts a new game by initializing the board and setting up the pieces.
     */
    public void newGame () {
        _board = new Board();
        setupPieces();
    }

    /**
     * Sets up the initial configuration of the chess pieces on the board.
     */
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

    /**
     * Moves a chess piece from the specified original position to the specified destination position.
     *
     * @param origFile  The file (column) of the original position.
     * @param origRank  The rank (row) of the original position.
     * @param destFile  The file (column) of the destination position.
     * @param destRank  The rank (row) of the destination position.
     */
    public void move(int origFile, int origRank, int destFile, int destRank) {
        // Get the piece at the original position
        Piece piece = _board.getTile(origFile, origRank).getPiece();
        // Remove the piece from the original position
        _board.getTile(origFile, origRank).setPiece(null);

        // Place the piece at the destination position
        _board.getTile(destFile, destRank).setPiece(piece);
    }

    /**
     * Retrieves the current state of the chess board.
     *
     * @return The chess board.
     */
    public Board getBoard(){
        return _board;
    }

    private Board _board;
}
