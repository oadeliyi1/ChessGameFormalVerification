package main;

import pieces.King;
import pieces.Pawn;

public class TurnOrderTest {
    public static void main(String[] args) {
        Board board = new Board(0,true);
        // Start the game to initialize timers
        //board.timer.startGame();
        // ChessTimerGUI timer = new ChessTimerGUI(board, "bullet", "Player 1", "Player 2");

        testTurnOrder(board);
    }

    public static void testTurnOrder(Board board) {
        // Clear the board and add two pawns, one for each player
        board.pieceList.clear();

        Pawn whitePawn = new Pawn(board, 6, 4, true);
        Pawn blackPawn = new Pawn(board, 1, 4, false);
        board.pieceList.add(whitePawn);
        board.pieceList.add(blackPawn);

        // Add Kings to avoid accidental checkmate/stalemate
        King whiteKing = new King(board, 7, 4, true);
        King blackKing = new King(board, 0, 4, false);
        board.pieceList.add(whiteKing);
        board.pieceList.add(blackKing);

        // Ensure it's White's turn initially
        assert board.p1.turn() : "Initial turn should be White's";
        assert !board.p2.turn() : "Initial turn should not be Black's";

        // White moves a piece (valid move)
        Move validWhiteMove = new Move(board, whitePawn, 5, 4);
        assert board.isValidMove(validWhiteMove) : "White piece should be allowed to move during White's turn";
        board.move(validWhiteMove);

        // Ensure turn flipped to Black
        assert !board.p1.turn() : "After White's move, it should not be White's turn";
        assert board.p2.turn() : "After White's move, it should be Black's turn";

        // Black tries to move (valid move)
        Move validBlackMove = new Move(board, blackPawn, 2, 4);
        assert board.isValidMove(validBlackMove) : "Black piece should be allowed to move during Black's turn";
        board.move(validBlackMove);

        // Ensure turn flipped back to White
        assert board.p1.turn() : "After Black's move, it should be White's turn";
        assert !board.p2.turn() : "After Black's move, it should not be Black's turn";

        // Black tries to move out of turn (invalid move)
        Move invalidBlackMove = new Move(board, blackPawn, 1, 4);
        assert !board.isValidMove(invalidBlackMove) : "Black piece should not be allowed to move during White's turn";

        // White tries to move out of turn (invalid move during Black's turn)
        board.p1.nextTurn(false); // Force flip to Black for testing
        board.p2.nextTurn(true);
        Move invalidWhiteMove = new Move(board, whitePawn, 4, 4);
        assert !board.isValidMove(invalidWhiteMove) : "White piece should not be allowed to move during Black's turn";

        System.out.println("Test passed: Turn order is correctly enforced.");
    }
}
