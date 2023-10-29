import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Board {

    public static final String START_FEN = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
    private static final Map<Character, Integer> SYM_TO_INT = initMap();
    public long[] _pieceBitboards;

    private static Map<Character, Integer> initMap() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('P', Piece.WhitePawn);
        map.put('R', Piece.WhiteRook);
        map.put('N', Piece.WhiteKnight);
        map.put('B', Piece.WhiteBishop);
        map.put('Q', Piece.WhiteQueen);
        map.put('K', Piece.WhiteKing);
        map.put('p', Piece.BlackPawn);
        map.put('r', Piece.BlackRook);
        map.put('n', Piece.BlackKnight);
        map.put('b', Piece.BlackBishop);
        map.put('q', Piece.BlackQueen);
        map.put('k', Piece.BlackKing);
        return Collections.unmodifiableMap(map);
    }

    public Board() {
        _pieceBitboards = new long[15];
    }


    public void updateBoard(Move move) {
        int pieceToMove = move.startSquare;
        int pieceToCapture = move.targetSquare;
    }

    public void loadFEN(String fen) {
        String[] fens = fen.split(" ");
        String boardFen = fens[0];
        int rank = 7;
        int file = 0;
        for (char c : boardFen.toCharArray()) {
            if (c == '/') {
                rank--;
                file = 0;
            } else if (Character.isDigit(c)) {
                file += Integer.parseInt(c + "");
            } else {
                _pieceBitboards[SYM_TO_INT.get(c)] |= 1L << (rank * 8 + file);
                file++;
            }
        }
    }

    public static void main(String[] args) {
        Board board = new Board();
        board.loadFEN(START_FEN);

        for (int i = 0; i < 15; i++) {
            System.out.println("Piece " + i + " bitboard: " + Long.toBinaryString(board._pieceBitboards[i]));
        }
    }

}
