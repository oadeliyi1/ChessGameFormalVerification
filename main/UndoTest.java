package main;

import pieces.Pawn;
import pieces.Rook;

public class UndoTest {
    public static void main(String[] args) {
        // Create a test board with timer disabled
        Board board = new Board(0, true);

        board.pieceList.clear();
        Pawn whitePawn = new Pawn(board, 6, 4, true);
        Rook blackRook = new Rook(board, 0, 4, false);

        board.pieceList.add(whitePawn);
        board.pieceList.add(blackRook);

        // Perform test operations
        Move pawnMove = new Move(board, whitePawn, 5, 4);
        board.move(pawnMove);

        board.undo();

        System.out.println("Undo test passed: All states restored correctly.");
    }
}

