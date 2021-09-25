/**
 * @author Devin A. Baldi
 */
public class EmptySpace extends Piece {
    public EmptySpace() {
        setType(-1);
        setXPos(-1);
        setYPos(-1);
        setPlayer(-1);
    }

    public boolean canMove(int x, int y) {
        return false;
    }
}
