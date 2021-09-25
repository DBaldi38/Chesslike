public class Main {
    public static void main(String[] args) throws Exception {
        GameplayManager gm = new GameplayManager();

        //gm.print();

        // Pawn testing
        // System.out.println(gm.movePiece(1, 6, 1, 4));
        // System.out.println(gm.movePiece(1, 4, 1, 2));
        // System.out.println(gm.movePiece(0, 1, 0, 3));
        // System.out.println(gm.movePiece(1, 1, 1, 3));
        // System.out.println(gm.movePiece(1, 4, 1, 3));

        // Rook testing
        // System.out.println(gm.movePiece(0, 1, 0, 3));
        // System.out.println(gm.movePiece(7, 1, 7, 2));
        // System.out.println(gm.movePiece(7, 6, 7, 4));

        // System.out.println(gm.movePiece(0, 0, 0, 2));
        // System.out.println(gm.movePiece(0, 2, 7, 3));
        // System.out.println(gm.movePiece(0, 2, 7, 2));
        // System.out.println(gm.movePiece(0, 2, 6, 2));
        // System.out.println(gm.movePiece(6, 2, 6, 4));
        // System.out.println(gm.movePiece(6, 4, 7, 4));

        // Knight testing
        // System.out.println(gm.movePiece(1, 0, 0, 3));
        // System.out.println(gm.movePiece(1, 0, 3, 1));
        // System.out.println(gm.movePiece(1, 0, 0, 2));
        // System.out.println(gm.movePiece(0, 2, 1, 3));
        // System.out.println(gm.movePiece(0, 2, 2, 3));
        // System.out.println(gm.movePiece(2, 3, 3, 5));
        // System.out.println(gm.movePiece(3, 5, 4, 7));

        // Bishop testing
        // System.out.println(gm.movePiece(3, 1, 3, 3));

        // System.out.println(gm.movePiece(2, 0, 2, 3));
        // System.out.println(gm.movePiece(2, 0, 4, 2));
        // System.out.println(gm.movePiece(4, 2, 0, 6));
        // System.out.println(gm.movePiece(4, 2, 5, 3));
        // System.out.println(gm.movePiece(5, 3, 1, 7));
        // System.out.println(gm.movePiece(5, 3, 2, 6));

        // Queen testing
        // System.out.println(gm.movePiece(4, 1, 4, 2));
        // System.out.println(gm.movePiece(6, 1, 6, 3));

        // System.out.println(gm.movePiece(3, 0, 3, 1));
        // System.out.println(gm.movePiece(3, 0, 6, 3));
        // System.out.println(gm.movePiece(3, 0, 5, 2));
        // System.out.println(gm.movePiece(5, 2, 5, 7));
        // System.out.println(gm.movePiece(5, 2, 0, 7));
        // System.out.println(gm.movePiece(5, 2, 1, 6));
        // System.out.println(gm.movePiece(1, 6, 5, 6));

        // King testing
        // System.out.println(gm.movePiece(4, 6, 4, 4));

        // System.out.println(gm.movePiece(4, 7, 4, 5));
        // System.out.println(gm.movePiece(4, 7, 3, 6));
        // System.out.println(gm.movePiece(4, 7, 4, 6));
        // System.out.println(gm.movePiece(4, 6, 3, 5));

        //gm.print();
        
        // isDanger testing
        // for (int i = 0; i < 8; i++) {
        //     for (int j = 0; j < 8; j++) {
        //         System.out.print(gm.isDanger(j, i, 1) + " ");
        //     }
        //     System.out.println();
        // }

        // isCheck testing
        gm.movePiece(5, 6, 5, 5);
        gm.movePiece(4, 1, 4, 3);
        gm.movePiece(6, 6, 6, 4);
        gm.movePiece(3, 0, 7, 4);

        gm.print();
        if (gm.isCheck(2)) {
            System.out.println("White is in check!");
        }
        if (gm.isCheck(1)) {
            System.out.println("Black is in check!");
        }

        // removePiece testing
        // TODO
        
    }
}
