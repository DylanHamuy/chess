import java.util.HashMap;

/**
 * The first three bits of binary represent the piece
 * The last two bits of binary represent the color
 */
public class Piece {
    public static final int NONE = 0;
    public static final int PAWN = 1;
    public static final int ROOK = 2;
    public static final int KNIGHT = 3;
    public static final int BISHOP = 4;
    public static final int QUEEN = 5;
    public static final int KING = 6;

    public static final int WHITE = 0;
    public static final int BLACK = 8;

    public static final int WhitePawn = PAWN | WHITE; // 1 (3 bits for PAWN, 2 bits for WHITE)
    public static final int WhiteKnight = KNIGHT | WHITE; // 3
    public static final int WhiteBishop = BISHOP | WHITE; // 4
    public static final int WhiteRook = ROOK | WHITE; // 2
    public static final int WhiteQueen = QUEEN | WHITE; // 5
    public static final int WhiteKing = KING | WHITE; // 6

    public static final int BlackPawn = PAWN | BLACK; // 9 (3 bits for PAWN, 2 bits for BLACK)
    public static final int BlackKnight = KNIGHT | BLACK; // 11
    public static final int BlackBishop = BISHOP | BLACK; // 12
    public static final int BlackRook = ROOK | BLACK; // 10
    public static final int BlackQueen = QUEEN | BLACK; // 13
    public static final int BlackKing = KING | BLACK; // 14
}
