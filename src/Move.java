public class Move {
    short moveValue;
    private final short startSquareMask = 0b0000000000111111;
	private final short targetSquareMask = 0b0000111111000000;
    int startSquare;
    int targetSquare;
    public Move(int startSquare, int targetSquare) {
        moveValue = (short) (startSquare | targetSquare << 6);
        this.startSquare = moveValue & startSquareMask;
        this.targetSquare = (moveValue & targetSquareMask) >> 6;
    }

}
