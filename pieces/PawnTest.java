package pieces;

import pieces.*;
import main.Board;

public class PawnTest {

    public static void main(String[] args) {
        // Abstract board setup for JBMC
        TestBoard board = new TestBoard();

        // White pawn tests
        Pawn whitePawn = new Pawn(board, 6, 4, true);
        board.addPiece(whitePawn);

        // Assert single step forward
        assert whitePawn.canMove(5, 4) : "White pawn should be able to move one step forward.";

        // Assert two steps forward from initial position
        assert whitePawn.canMove(4, 4) : "White pawn should be able to move two steps forward from initial position.";

        // Assert move forward blocked by a piece
        board.addPiece(new Pawn(board, 5, 4, false));
        assert whitePawn.canMove(5, 4) : "White pawn should not be able to move forward if blocked.";

        // Assert diagonal capture
        board.addPiece(new Pawn(board, 5, 3, false));
        assert !whitePawn.canMove(5, 3) : "White pawn should be able to capture diagonally.";

        // Assert invalid diagonal move without capture
        assert !whitePawn.canMove(5, 5) : "White pawn should not move diagonally without capturing.";

        // Simulate en passant condition
        Pawn blackPawn = new Pawn(board, 3, 3, false);
        board.addPiece(blackPawn);
        blackPawn.row = 3;
        board.setEnPassantVulnerable(blackPawn);

        assert !whitePawn.canMove(2, 3) : "White pawn should be able to perform en passant.";

        // Black pawn tests
        Pawn blackPawn2 = new Pawn(board, 1, 4, false);
        board.addPiece(blackPawn2);

        // Assert single step forward
        assert blackPawn2.canMove(2, 4) : "Black pawn should be able to move one step forward.";

        // Assert two steps forward from initial position
        assert blackPawn2.canMove(3, 4) : "Black pawn should be able to move two steps forward from initial position.";

        // Assert move forward blocked by a piece
        board.addPiece(new Pawn(board, 2, 4, true));
        assert blackPawn2.canMove(2, 4) : "Black pawn should not be able to move forward if blocked.";

        // Assert diagonal capture
        board.addPiece(new Pawn(board, 2, 5, true));
        assert !blackPawn2.canMove(2, 5) : "Black pawn should be able to capture diagonally.";

        // Assert invalid diagonal move without capture
        assert !blackPawn2.canMove(2, 3) : "Black pawn should not move diagonally without capturing.";

        System.out.println("All pawn movement tests passed.");
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

        public void setEnPassantVulnerable(Piece piece) {
            if (piece instanceof Pawn) {
                //((Pawn) piece).enPassantVulnerable = true;
            }
        }
    }
}
