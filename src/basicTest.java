import chess.piece.Pawn;
import org.junit.Test;
import static org.junit.Assert.assertTrue;


public class basicTest {
    @Test
    public void testSETUP() {
        Game test = new Game();
        test.setupPieces();
        assertTrue(test.getBoard().getTile(1,1).getPiece() instanceof Pawn);

    }
}

