/**
 * @author Devin A. Baldi
 */
public class Knight extends Piece {
    public Knight(int player, int x, int y) {
        setType(3);
        setPlayer(player);
        setXPos(x);
        setYPos(y);
    }

    @Override
    public boolean canMove(int x, int y) {
        int delX = x - this.getXPos();
        int delY = y - this.getYPos();
        if (delX*delX + delY*delY == 5) {
            return true;
        }
        return false;
    }
}
