package main;

import pieces.King;
import pieces.Rook;

public class CheckMateTest {
    public static void main(String[] args) {
        Board board = new Board(0, true); // Use test mode to disable unnecessary components
        board.pieceList.clear(); // Clear the board for setup

        King whiteKing = new King(board, 7, 4, true);
        board.pieceList.add(whiteKing);

        Rook blackRook1 = new Rook(board, 6, 4, false); // Vertical threat
        Rook blackRook2 = new Rook(board, 7, 5, false); // Horizontal threat
        board.pieceList.add(blackRook1);
        board.pieceList.add(blackRook2);

        boolean isWhiteCheckmated = board.isCheckMated(true);
        if (isWhiteCheckmated) {
            System.out.println("Test passed: White king is correctly detected in Checkmate.");
        } else {
            throw new AssertionError("Test failed: White king should be in Checkmate.");
        }
    }
}
