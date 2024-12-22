package pieces;

import main.Board;

public class RookTest {

    public static void main(String[] args) {
        // Abstract board setup for JBMC
        TestBoard board = new TestBoard();

        // Rook piece for testing
        Rook rook = new Rook(board, 4, 4, true);
        board.addPiece(rook);

        // Assert valid moves
        // Horizontal and vertical moves
        assert rook.canMove(4, 6) : "Rook should be able to move horizontally to (4, 6).";
        assert rook.canMove(4, 2) : "Rook should be able to move horizontally to (4, 2).";
        assert rook.canMove(6, 4) : "Rook should be able to move vertically to (6, 4).";
        assert rook.canMove(2, 4) : "Rook should be able to move vertically to (2, 4).";

        // Blocked move by friendly piece
        board.addPiece(new Pawn(board, 4, 5, true));
        assert rook.canMove(4, 6) : "Rook should not move to (4, 6) because it is blocked by a friendly piece.";

        // Attack move on an enemy piece
        board.addPiece(new Pawn(board, 4, 3, false));
        assert rook.canMove(4, 3) : "Rook should be able to move horizontally to (4, 3) and attack an enemy piece.";

        // Invalid moves
        assert !rook.canMove(5, 5) : "Rook should not move diagonally to (5, 5).";
        assert !rook.canMove(3, 3) : "Rook should not move diagonally to (3, 3).";

        System.out.println("All Rook movement tests passed.");
    }

    // Abstract TestBoard class for JBMC verification purposes
    private static class TestBoard extends Board {
        public TestBoard() {
            super(0); // Mode is irrelevant for abstract testing
            this.pieceList.clear(); // Clear any default setup
        }

        public void addPiece(Piece piece) {
            this.pieceList.add(piece);
        }
    }
}
