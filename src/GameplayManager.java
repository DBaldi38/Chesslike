/**
 * Manages the gameplay of the game of Chess
 * 
 * @author Devin A. Baldi
 */
public class GameplayManager {
    private Board board;
    private boolean whiteTurn;
    public GameplayManager() {
        board = new Board();
        board.boardSetup();
        whiteTurn = true;;          //White goes first
    }

    public void print() {
        System.out.println(board);
    }

    public void playTurn() {
        //FIXME
    }

    public boolean movePiece(int xi, int yi, int xf, int yf) {
        // Make sure the movement would not be out of bounds
        if (outOfBounds(xi, yi)) {
            return false;
        } else if (outOfBounds(xf, yf)) {
            return false;
        }
        Piece toMove = board.getPiece(xi, yi);

        // Check if the move can be made by the piece, and make sure the place to move is not occupied by a piece of the same team 
        // (This also takes care of edge case where someone tries to move to the same location)
        if (!toMove.canMove(xf,yf)) {
            return false;
        } else if (!(board.getPiece(xf, yf).getType() == -1)) {
            if (board.getPiece(xf, yf).getPlayer() == toMove.getPlayer()) {
                return false;
            }
        }
        // Check for pieces in the way of movement
        if (!moveAllow(toMove, xf, yf)) {
            return false;
        }
        
        // Remove any taken pieces from the enemy's list
        board.removePiece(board.getPiece(xf, yf));
        // Make the move
        board.setPiece(toMove.getXPos(), toMove.getYPos(), new EmptySpace());
        board.setPiece(xf, yf, toMove);
        //TODO: Make castling a move; probably implement last
        return true;
    }

    public boolean outOfBounds(int x, int y) {
        return !((x >= 0)&&(y >= 0) && (x < board.getSize())&&(y < board.getSize()));
    }

    public boolean moveAllow(Piece toMove, int xf, int yf) {
        switch(toMove.getType()) {
            case 0:
                if (!kingAllow(toMove, xf, yf)) {
                    return false;
                }
                break;
            case 1:
                if (!queenAllow(toMove, xf, yf)) {
                    return false;
                }
                break;
            case 2:
                if (!bishopAllow(toMove, xf, yf)) {
                    return false;
                }
                break;
            case 3:
                if (!knightAllow(toMove, xf, yf)) {
                    return false;
                }
                break;
            case 4:
                if (!rookAllow(toMove, xf, yf)) {
                    return false;
                }
                break;
            case 5:
                if (!pawnAllow(toMove, xf, yf)) {
                    return false;
                }
                if (!((Pawn)toMove).hasMoved()) {
                    ((Pawn)toMove).firstMove();
                }
                break;
            case -1:
                return false;
        }
        return true;
    }

    // Temporary method for testing FIXME
    public Piece getPiece(int x, int y) {
        return board.getPiece(x, y);
    }

    // Checks for pieces in the way of movement
    public boolean pawnAllow(Piece pawn, int x, int y) {
        Piece target = getPiece(x, y);
        // The Pawn cannot attack in a straight line
        if (x == pawn.getXPos()) {
            if (target.getType() != -1) {
                return false;
            }
        } else if (target.getType() == -1) {   // The Pawn cannot move diagonally unless attacking
            return false;
        }
        
        return true;
    }

    public boolean pawnThreat(Piece pawn, int x, int y) {
        if (pawn.getPlayer() == 2) {
            return ((y == pawn.getYPos()-1)&&((x == pawn.getXPos()-1)||(x == pawn.getXPos()+1)));
        } else if (pawn.getPlayer() == 1) {
            return ((y == pawn.getYPos()+1)&&((x == pawn.getXPos()-1)||(x == pawn.getXPos()+1)));
        }
        return false;
    }

    public boolean kingAllow(Piece king, int x, int y) {
        if (isDanger(x, y, king.getPlayer())) {
            return false;
        }
        return true;
    }

    public boolean queenAllow(Piece queen, int x, int y) {
        if ((queen.getXPos() == x)||(queen.getYPos() == y)) {
            return rookAllow(queen, x, y);
        }
        return bishopAllow(queen, x, y);
    }

    public boolean bishopAllow(Piece bishop, int x, int y) {
        if ((x > bishop.getXPos())&&(y > bishop.getYPos())) { // Moving top-left to bot-right
            for (int i = 1; i < x-bishop.getXPos(); i++) {
                if (board.getPiece(bishop.getXPos()+i, bishop.getYPos()+i).getPlayer() != -1) {
                    return false;
                }
            }
        } else if ((x < bishop.getXPos())&&(y < bishop.getYPos())) { // Moving bot-right to top-left
            for (int i = 1; i > bishop.getXPos()-x; i++) {
                if (board.getPiece(bishop.getXPos()-i, bishop.getYPos()-i).getPlayer() != -1) {
                    return false;
                }
            }
        } else if (y < bishop.getYPos()) { // Moving bot-left to top-right
            for (int i = 1; i < x-bishop.getXPos(); i++) {
                if (board.getPiece(bishop.getXPos()+i, bishop.getYPos()-i).getPlayer() != -1) {
                    return false;
                }
            }
        } else { // Moving top-right to bot-left
            for (int i = 1; i < y-bishop.getYPos(); i++) {
                if (board.getPiece(bishop.getXPos()-i, bishop.getYPos()+i).getPlayer() != -1) {
                    return false;
                }
            }
        }
        
        return true;
    }

    public boolean knightAllow(Piece knight, int x, int y) {
        //TODO
        // May not be needed; TBD
        return true;
    }

    public boolean rookAllow(Piece rook, int x, int y) {
        if (rook.getXPos()==x) { // Vertical movement
            if (rook.getYPos() > y) {
                for (int curY = y+1; curY < rook.getYPos(); curY++) {
                    if (board.getPiece(x,curY).getPlayer() != -1) {
                        return false;
                    }
                }
            } else {
                for (int curY = rook.getYPos()+1; curY < y; curY++) {
                    if (board.getPiece(x,curY).getPlayer() != -1) {
                        return false;
                    }
                }
            }
        } else if (rook.getYPos()==y) { // Horizontal movement
            if (rook.getXPos() > x) {
                for (int curX = x+1; curX < rook.getXPos(); curX++) {
                    if (board.getPiece(curX,y).getPlayer() != -1) {
                        return false;
                    }
                }
            } else {
                for (int curX = rook.getXPos()+1; curX < x; curX++) {
                    if (board.getPiece(curX,y).getPlayer() != -1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Checks if the king belonging to player is under threat by any enemy piece.
     * @param player 1 for black, 2 for white.
     * @return boolean true if the king is in check.
     */
    public boolean isCheck(int player) {
        // FIXME: Better solution: add threatening boolean to Piece and just check this (and update threatening every move)
        if (player == 1) {
            if (isDanger(board.getBlackKing().getXPos(), board.getBlackKing().getYPos(), player)) {
                return true;
            }
        } else if (player == 2) {
            if (isDanger(board.getWhiteKing().getXPos(), board.getWhiteKing().getYPos(), player)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns true if the board location (xf,yf) is under threat by any piece that is an enemy of player.
     * @param xf x coordinate on game board
     * @param yf y coordinate on game board. +y value cooresponds to a lower position on the board.
     * @param player 1 for black, 2 for white.
     * @return boolean True if a piece belonging to player would be under threat at location (x,y)
     */
    public boolean isDanger(int xf, int yf, int player) {

        if (outOfBounds(xf, yf)) {
            return false;
        }
        if (player == 1) { // White is the enemy
            for (Piece p : board.getWhitePieces()) {
                if (p.getType() == 0) {
                    if (p.canMove(xf, yf)) {
                        return true;
                    }
                } else if (p.getType() == 5) {
                    if (p.canMove(xf, yf)&&pawnThreat(p, xf, yf)) {
                        return true;
                    }
                } else
                if (p.canMove(xf, yf)&&moveAllow(p, xf, yf)) {
                    return true;
                }
            }
        } else if (player == 2) {   // Black is the enemy
            for (Piece p : board.getBlackPieces()) {
                if (p.getType() == 0) {
                    if (p.canMove(xf, yf)) {
                        return true;
                    }
                } else if (p.getType() == 5) {
                    if (p.canMove(xf, yf)&&pawnThreat(p, xf, yf)) {
                        return true;
                    }
                } else
                if (p.canMove(xf, yf)&&moveAllow(p, xf, yf)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void pawnPromotion(Piece pawn) {
        // TODO
    }
}
