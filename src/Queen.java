/**
 * @author Devin A. Baldi
 */
public class Queen extends Piece {
    public Queen(int player, int x, int y) {
        setType(1);
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
        if ((delX == 0)^(delY == 0)) {
            return true;
        }
        return false;
    }
}
