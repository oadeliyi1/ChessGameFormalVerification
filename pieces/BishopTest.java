package pieces;

import main.Board;

public class BishopTest {
    public static void main(String[] args) {
        // Create a dummy board
        Board board = new Board(0); // Mode 0 for default chess setup

        // Create a Bishop and place it at (4, 4)
        Bishop bishop = new Bishop(board, 4, 4, true); // White Bishop at (4, 4)

        // Test the Bishop's movement
        testBishopMovement(bishop, board);

        System.out.println("All Bishop movement tests passed.");
    }

    public static void testBishopMovement(Bishop bishop, Board board) {
        // Valid diagonal movements (assuming no pieces blocking)
        int[][] validMoves = {
                {3, 3}, {2, 2}, {1, 1}, {0, 0}, // Top-left diagonal
                {5, 5}, {6, 6}, {7, 7},        // Bottom-right diagonal
                {3, 5}, {2, 6}, {1, 7},        // Top-right diagonal
                {5, 3}, {6, 2}, {7, 1}         // Bottom-left diagonal
        };

        for (int[] move : validMoves) {
            int newRow = move[0];
            int newCol = move[1];
            assert bishop.canMove(newRow, newCol) : "Bishop should be able to move to (" + newRow + ", " + newCol + ")";
        }

        // Invalid moves (non-diagonal or blocked positions)
        int[][] invalidMoves = {
                {4, 4}, {4, 5}, {5, 4}, {3, 4}, // Adjacent non-diagonal moves
                {0, 7}, {7, 0}                  // Positions outside diagonal paths
        };

        for (int[] move : invalidMoves) {
            int newRow = move[0];
            int newCol = move[1];
            assert !bishop.canMove(newRow, newCol) : "Bishop should not be able to move to (" + newRow + ", " + newCol + ")";
        }

        // Block the Bishop's diagonal paths with pieces
        board.pieceList.add(new Pawn(board, 3, 3, true)); // Block top-left
        board.pieceList.add(new Pawn(board, 5, 5, true)); // Block bottom-right

        assert bishop.canMove(2, 2) : "Bishop should not move past blocking piece at (3, 3)";
        assert bishop.canMove(6, 6) : "Bishop should not move past blocking piece at (5, 5)";
    }
}
