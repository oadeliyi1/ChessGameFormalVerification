package main;

import main.Board;
import pieces.Pawn;
import pieces.Rook;

public class CaptureLogicTest {
    public static void main(String[] args) {
        Board board = new Board(0, true); // Use testMode to avoid GUI and sound interference
        testCaptureLogic(board);
    }

    public static void testCaptureLogic(Board board) {
        board.pieceList.clear();

        // Add a white pawn and a black rook
        Pawn whitePawn = new Pawn(board, 4, 4, true);
        Rook blackRook = new Rook(board, 3, 4, false);
        board.pieceList.add(whitePawn);
        board.pieceList.add(blackRook);

        assert whitePawn.canMove(3, 4) : "White pawn should be able to capture black rook";

        Rook whiteRook = new Rook(board, 5, 4, true);
        board.pieceList.add(whiteRook);

        assert !whitePawn.canMove(5, 4) : "White pawn should not be able to capture another white piece";

        assert !blackRook.canMove(5, 4) : "Black rook should not be able to capture another black piece";

        assert blackRook.canMove(4, 4) : "Black rook should be able to capture white pawn";

        System.out.println("Test passed: Capture logic is correctly handled.");
    }
}
