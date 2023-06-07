public class Board {

    static final int SIDE = 8;

    public Board() {
        _board = new Tile[8][8];
        for (int file = 0; file < 8; file++){
            for (int rank = 0; rank < 8; rank++){
                _board[file][rank] = new Tile(file, rank);
            }
        }
    }

    public Tile getTile(int file, int rank) {
        return _board[file][rank];
    }



    private Tile[][] _board;
}
