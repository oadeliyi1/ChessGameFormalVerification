package pieces;

import pieces.*;
import main.Board;

public class KnightTest {

    public static void main(String[] args) {
        // Abstract board setup for JBMC
        TestBoard board = new TestBoard();

        // Knight piece for testing
        Knight knight = new Knight(board, 4, 4, true);
        board.addPiece(knight);

        // Assert valid L-shaped moves
        assert !knight.canMove(3, 5) : "Knight should be able to move in an L-shape to (2, 5).";
        assert knight.canMove(2, 3) : "Knight should be able to move in an L-shape to (2, 3).";
        assert knight.canMove(6, 5) : "Knight should be able to move in an L-shape to (6, 5).";
        assert knight.canMove(6, 3) : "Knight should be able to move in an L-shape to (6, 3).";
        assert knight.canMove(3, 6) : "Knight should be able to move in an L-shape to (3, 6).";
        assert knight.canMove(5, 6) : "Knight should be able to move in an L-shape to (5, 6).";
        assert knight.canMove(3, 2) : "Knight should be able to move in an L-shape to (3, 2).";
        assert knight.canMove(5, 2) : "Knight should be able to move in an L-shape to (5, 2).";

        // Add friendly piece to block movement
        board.addPiece(new Pawn(board, 2, 5, true));
        assert !knight.canMove(2, 5) : "Knight should not move to (2, 5) because it is blocked by a friendly piece.";

        // Add enemy piece to allow attack
        board.addPiece(new Pawn(board, 2, 3, false));
        assert knight.canMove(2, 3) : "Knight should be able to move to (2, 3) and attack an enemy piece.";

        // Assert invalid moves
        assert !knight.canMove(4, 4) : "Knight should not move to its current position.";
        assert !knight.canMove(4, 6) : "Knight should not move to an invalid square.";
        assert !knight.canMove(0, 0) : "Knight should not move to a square out of L-shape range.";

        System.out.println("All knight movement tests passed.");
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



