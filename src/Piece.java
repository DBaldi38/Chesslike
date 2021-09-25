/**
 * Any chess piece (pawn, rook, knight, bishop, queen, or king)
 * @author Devin A. Baldi
 */
public abstract class Piece {
    private int player; // Player 1 is black, player 2 is white
    private int type; // 0 for King, 1 for Queen, 2 for Bishop, 3 for Knight, 4 for Rook, 5 for Pawn, -1 for Empty Space
    private int xPos;
    private int yPos;

    // Getters
    public int getPlayer() {
        return this.player;
    }
    public int getType() {
        return this.type;
    }
    public int getXPos() {
        return this.xPos;
    }
    public int getYPos() {
        return this.yPos;
    }
    // Setters
    public void setPlayer(int player) {
        this.player = player;
    }
    public void setType(int type) {
        this.type = type;
    }
    public void setXPos(int x) {
        this.xPos = x;
    }
    public void setYPos(int y) {
        this.yPos = y;
    }

    @Override
    public String toString() {
        String toReturn = "";

        switch (getType()) {
            case 0:
                toReturn += "K";
                break;
            case 1:
                toReturn += "Q";
                break;
            case 2:
                toReturn += "B";
                break;
            case 3:
                toReturn += "N";
                break;
            case 4:
                toReturn += "R";
                break;
            case 5:
                toReturn += "P";
                break;
            case -1:
                toReturn += ".";
        }

        return toReturn;
    }

    // Each piece must have its own movement rules
    /**
     * Checks if the location we want to move falls within the directional rules for movement for this piece.
     * Warning: Does not check for collisions; only checks if the movement would make sense to begin with for this piece.
     * @param x Target 'x' location on the board
     * @param y Target 'y' location on the board
     * @return boolean true if, with no obstructions, this piece should be able to move to the target location.
     */
    public abstract boolean canMove(int x, int y);
}
