/**
 * @author Devin A. Baldi
 */
public class Bishop extends Piece {
    public Bishop(int player, int x, int y) {
        setType(2);
        setPlayer(player);
        setXPos(x);
        setYPos(y);
    }

    @Override
    public boolean canMove(int x, int y) {
        int delX = x - this.getXPos();
        int delY = y - this.getYPos();
        if ((delX == 0)&&(delY == 0)) {
            return false;
        }
        if (delX*delX == delY*delY) {
            return true;
        }
        return false;
    }
}
