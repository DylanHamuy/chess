import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Board {

    private int[] _board;
    public static final String START_FEN = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
    private static final Map<Character, Integer> SYM_TO_INT = initMap();

    private static Map<Character, Integer> initMap() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('p', Piece.PAWN);
        map.put('r', Piece.ROOK);
        map.put('n', Piece.KNIGHT);
        map.put('b', Piece.BISHOP);
        map.put('q', Piece.QUEEN);
        map.put('k', Piece.KING);
        return Collections.unmodifiableMap(map);
    }

    public Board() {
        _board = new int[64];
    }

    public int[] getBoard() {
        return _board;
    }

    public void loadFEN(String fen) {
        String[] fens = fen.split(" ");
        String board = fens[0];
        int rank = 7;
        int file = 0;
        for (int i = 0; i < board.length(); i++) {
            char c = board.charAt(i);
            if (c == '/') {
                rank--;
                file = 0;
            } else if (Character.isDigit(c)) {
                file += Integer.parseInt(c + "");
            } else {
                if (Character.isLowerCase(c)) {
                    _board[file + rank * 8] =  Piece.BLACK | SYM_TO_INT.get(c);
                } else {
                    _board[file + rank * 8] =  Piece.WHITE | SYM_TO_INT.get(Character.toLowerCase(c));
                }
                file++;
            }
        }
    }
}
