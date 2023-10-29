import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BasicTest {

    @Test
    public void testLoadFEN() {
        Board board = new Board();
        board.loadFEN(Board.START_FEN);

        long[] expectedBitboards = new long[15];
        expectedBitboards[Piece.WhitePawn] = 0b0000000000000000000000000000000000000000000000001111111100000000L;
        expectedBitboards[Piece.WhiteRook] = 0b0000000000000000000000000000000000000000000000000000000010000001L;
        expectedBitboards[Piece.WhiteKnight] = 0b00000000000000000000000000000000000000000000000000000000001000010L;
        expectedBitboards[Piece.WhiteBishop] = 0b0000000000000000000000000000000000000000000000000000000000100100L;
        expectedBitboards[Piece.WhiteQueen] = 0b00000000000000000000000000000000000000000000000000000000000001000L;
        expectedBitboards[Piece.WhiteKing] = 0b0000000000000000000000000000000000000000000000000000000000010000L;
        expectedBitboards[Piece.BlackPawn] = 0b0000000011111111000000000000000000000000000000000000000000000000L;
        expectedBitboards[Piece.BlackRook] = 0b1000000100000000000000000000000000000000000000000000000000000000L;
        expectedBitboards[Piece.BlackKnight] = 0b0100001000000000000000000000000000000000000000000000000000000000L;
        expectedBitboards[Piece.BlackBishop] = 0b0010010000000000000000000000000000000000000000000000000000000000L;
        expectedBitboards[Piece.BlackQueen] = 0b0000100000000000000000000000000000000000000000000000000000000000L;
        expectedBitboards[Piece.BlackKing] = 0b0001000000000000000000000000000000000000000000000000000000000000L;


        for (int i = 0; i < 15; i++) {
            assertEquals("Piece " + i + " bitboard mismatch", expectedBitboards[i], board._pieceBitboards[i]);
        }
    }
}
