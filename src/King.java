/**
 * @author Devin A. Baldi
 */
public class King extends Piece {
    public King(int player, int x, int y) {
        setType(0);
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
        if ((delX*delX + delY*delY) <= 2) {
            return true;
        }
        
        return false;
    }
}
