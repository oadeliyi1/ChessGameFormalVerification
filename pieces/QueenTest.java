package pieces;

import main.Board;

public class QueenTest {

    public static void main(String[] args) {
        // Abstract board setup for JBMC
        TestBoard board = new TestBoard();

        // Queen piece for testing
        Queen queen = new Queen(board, 4, 4, true);
        board.addPiece(queen);

        // Assert valid moves
        // Horizontal and vertical moves
        assert queen.canMove(4, 6) : "Queen should be able to move horizontally to (4, 6).";
        assert queen.canMove(4, 2) : "Queen should be able to move horizontally to (4, 2).";
        assert queen.canMove(6, 4) : "Queen should be able to move vertically to (6, 4).";
        assert queen.canMove(2, 4) : "Queen should be able to move vertically to (2, 4).";

        // Diagonal moves
        assert queen.canMove(6, 6) : "Queen should be able to move diagonally to (6, 6).";
        assert queen.canMove(6, 2) : "Queen should be able to move diagonally to (6, 2).";
        assert queen.canMove(2, 6) : "Queen should be able to move diagonally to (2, 6).";
        assert queen.canMove(2, 2) : "Queen should be able to move diagonally to (2, 2).";

        // Blocked move by friendly piece
        board.addPiece(new Pawn(board, 4, 5, true));
        assert queen.canMove(4, 6) : "Queen should not move horizontally to (4, 6) because it is blocked by a friendly piece.";

        // Attack move on an enemy piece
        board.addPiece(new Pawn(board, 4, 3, false));
        assert queen.canMove(4, 3) : "Queen should be able to move horizontally to (4, 3) and attack an enemy piece.";

        // Invalid moves
        assert !queen.canMove(5, 6) : "Queen should not move to an invalid square (5, 6).";
        assert !queen.canMove(3, 1) : "Queen should not move to an invalid square (3, 1).";

        System.out.println("All Queen movement tests passed.");
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
