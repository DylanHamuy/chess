public class Board {

    private int[] _board;
    public final String START_FEN = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";

    public Board() {
        _board = new int[64];
    }

    public static void loadFEN(String fen) {
        String[] byRank = fen.split("/");

    }


}
