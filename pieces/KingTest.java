package pieces;

import main.Board;

public class KingTest {
    public static void main(String[] args) {
        // Create a dummy board
        Board board = new Board(0);

        // Manually place a king and surround it with other pieces
        King king = new King(board, 4, 4, true); // King at (4, 4)
        // Test the king cannot move
        testKing(king);
    }

    public static void testKing(King king) {
        // Check all directions
        int[][] directions = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1},          {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };

        for (int[] dir : directions) {
            int newRow = king.row + dir[0];
            int newCol = king.col + dir[1];

            // Assert that the king cannot move to any direction
            assert king.canMove(newRow, newCol) : "King should not move to (" + newRow + ", " + newCol + ")";
        }

        System.out.println("Test passed: King cannot move while surrounded by other pieces.");
    }
}
