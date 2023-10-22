import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class BasicTest {

    @Test
    public void testLoadFENBoard() {
        Board board = new Board();

        // FEN string with only the board part
        String fen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR";

        // Load the FEN string into the board
        board.loadFEN(fen);

        // Define the expected board representation with black and white pieces flipped
        int[] expectedBoard = {
                Piece.ROOK | Piece.WHITE, Piece.KNIGHT | Piece.WHITE, Piece.BISHOP | Piece.WHITE, Piece.QUEEN | Piece.WHITE,
                Piece.KING | Piece.WHITE, Piece.BISHOP | Piece.WHITE, Piece.KNIGHT | Piece.WHITE, Piece.ROOK | Piece.WHITE,
                Piece.PAWN | Piece.WHITE, Piece.PAWN | Piece.WHITE, Piece.PAWN | Piece.WHITE, Piece.PAWN | Piece.WHITE,
                Piece.PAWN | Piece.WHITE, Piece.PAWN | Piece.WHITE, Piece.PAWN | Piece.WHITE, Piece.PAWN | Piece.WHITE,
                0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0,
                Piece.PAWN | Piece.BLACK, Piece.PAWN | Piece.BLACK, Piece.PAWN | Piece.BLACK, Piece.PAWN | Piece.BLACK,
                Piece.PAWN | Piece.BLACK, Piece.PAWN | Piece.BLACK, Piece.PAWN | Piece.BLACK, Piece.PAWN | Piece.BLACK,
                Piece.ROOK | Piece.BLACK, Piece.KNIGHT | Piece.BLACK, Piece.BISHOP | Piece.BLACK, Piece.QUEEN | Piece.BLACK,
                Piece.KING | Piece.BLACK, Piece.BISHOP | Piece.BLACK, Piece.KNIGHT | Piece.BLACK, Piece.ROOK | Piece.BLACK
        };

        // Verify that the actual board matches the expected board
        assertArrayEquals(expectedBoard, board.getBoard());
    }
}
