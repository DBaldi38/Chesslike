/**
 * @author Devin A. Baldi
 */
public class Rook extends Piece {
    public Rook(int player, int x, int y) {
        setType(4);
        setPlayer(player);
        setXPos(x);
        setYPos(y);
    }

    @Override
    public boolean canMove(int x, int y) {
        if ((this.getXPos() != x)&&(this.getYPos() != y)) {
            return false;
        }
        if (((this.getXPos()-x)==0)&&((this.getYPos()-y)==0)) {
            return false;
        }
        return true;
    }
}
