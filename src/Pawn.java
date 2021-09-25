/**
 * @author Devin A. Baldi
 */
public class Pawn extends Piece {
    private boolean hasMoved;
    public Pawn(int player, int x, int y) {
        setType(5);
        setPlayer(player);
        setXPos(x);
        setYPos(y);
        hasMoved = false;
    }

    @Override
    public boolean canMove(int x, int y) {
        if (this.getPlayer() == 2) {
            if ((y == this.getYPos()-1) && (x >= this.getXPos()-1)&&(x <= this.getXPos()+1)) {
                return true;
            }
            if (!hasMoved()) { //FIXME Make sure the space between the pawn and the destination is not occupied
                if ((y < this.getYPos())&&(y >= this.getYPos()-2) && (x == this.getXPos())) {
                    return true;
                }
            }
        } else if (this.getPlayer() == 1) {
            if ((y == this.getYPos()+1) && (x >= this.getXPos()-1)&&(x <= this.getXPos()+1)) {
                return true;
            }
            if (!hasMoved()) { //FIXME Make sure the space between the pawn and the destination is not occupied
                if ((y > this.getYPos())&&(y <= this.getYPos()+2) && (x == this.getXPos())) {
                    return true;
                }
            }
        } else {
            System.err.println("Cannot move an empty space!");
        }
        
        return false;
    }

    public boolean hasMoved() {
        return this.hasMoved;
    }
    public void firstMove() {
        this.hasMoved = true;
    }
}
