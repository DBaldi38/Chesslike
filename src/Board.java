import java.util.ArrayList;

/**
 * A game board used for chess by default (8x8)
 * @author Devin A. Baldi
 */
public class Board {
    private Piece[][] tiles;
    private int size;
    private ArrayList<Piece> whitePieces;
    private Piece whiteKing;
    private ArrayList<Piece> blackPieces;
    private Piece blackKing;

    public Board() {
        size = 8;
        this.tiles = new Piece[size][size];
        this.whitePieces = new ArrayList<>(size);
        this.blackPieces = new ArrayList<>(size);
    }

    public int getSize() {
        return this.size;
    }

    // Our board layout is [column][row] (top-left starting point), so the first index actually corresponds to the y position
    public Piece getPiece(int x, int y) {
        return tiles[y][x];
    }
    public void setPiece(int x, int y, Piece newPiece) {
        if (!(newPiece == null)) {
            newPiece.setXPos(x);
            newPiece.setYPos(y);
        }
        tiles[y][x] = newPiece;
    }

    public ArrayList<Piece> getWhitePieces() {
        return this.whitePieces;
    }

    public Piece getWhiteKing() {
        return this.whiteKing;
    }

    public ArrayList<Piece> getBlackPieces() {
        return this.blackPieces;
    }

    public Piece getBlackKing() {
        return this.blackKing;
    }

    public boolean removePiece(Piece piece) {
        if (whitePieces.remove(piece)) {
            return true;
        } else if (!blackPieces.remove(piece)) {
            // System.err.println("Piece does not exist!");
            return false;
        }
        return true;
    }

    public void boardSetup() {
        // Player 1 (Black) pieces
        tiles[0][0] = new Rook(1,0,0);
        tiles[0][1] = new Knight(1,1,0);
        tiles[0][2] = new Bishop(1,2,0);
        tiles[0][3] = new Queen(1,3,0);
        tiles[0][4] = new King(1,4,0);
        blackKing = tiles[0][4];
        tiles[0][7] = new Rook(1,7,0);
        tiles[0][6] = new Knight(1,6,0);
        tiles[0][5] = new Bishop(1,5,0);
        for (int i = 0; i < 8; i++) {
            tiles[1][i] = new Pawn(1,i,1);
            blackPieces.add(tiles[0][i]);
            blackPieces.add(tiles[1][i]);
        }
        // Player 2 (White) pieces
        tiles[7][0] = new Rook(2,0,7);
        tiles[7][1] = new Knight(2,1,7);
        tiles[7][2] = new Bishop(2,2,7);
        tiles[7][3] = new Queen(2,3,7);
        tiles[7][4] = new King(2,4,7);
        whiteKing = tiles[7][4];
        tiles[7][7] = new Rook(2,7,7);
        tiles[7][6] = new Knight(2,6,7);
        tiles[7][5] = new Bishop(2,5,7);
        for (int i = 0; i < 8; i++) {
            tiles[6][i] = new Pawn(2,i,6);
            whitePieces.add(tiles[7][i]);
            whitePieces.add(tiles[6][i]);
        }
        // Empty Spaces
        for (int r = 2; r < 6; r++) {
            for (int c = 0; c < getSize(); c++) {
                tiles[r][c] = new EmptySpace();
            }
        }
    }

    @Override
    public String toString() {
        String toReturn = "";

        for (Piece[] r : tiles) {
            for (Piece c : r) {
                if (c == null) {
                    System.err.println("null space found");;
                } else {
                    toReturn += c.toString();
                }
            }
            toReturn += "\n";
        }

        return toReturn;
    }
}
