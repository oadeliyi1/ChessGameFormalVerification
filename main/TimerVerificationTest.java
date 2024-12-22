package main;

import pieces.Pawn;

public class TimerVerificationTest {

    public static void main(String[] args) {
        // Abstract board setup
        TestBoard board = new TestBoard();
        ChessTimerGUI timerGUI = new ChessTimerGUI(board, "bullet", "Player1", "Player2");

        // Property 1: Time counts
        // Verify that a move is only valid if the player's timer is greater than zero
        ChessTimerGUI.timer1 = 10; // Player 1 timer
        ChessTimerGUI.timer2 = 5;  // Player 2 timer

        assert board.isValidMove(new Move(board, new Pawn(board, 1, 1, true), 2, 1))
                : "Move should be valid while time remains for Player 1.";

        ChessTimerGUI.timer1 = 0; // Player 1 timer runs out
        assert !board.isValidMove(new Move(board, new Pawn(board, 1, 1, true), 2, 1))
                : "Move should not be valid if Player 1 timer is zero.";

        // Property 2: Time up
        // Verify that the game ends when a player's timer reaches zero, awarding a win to the opponent
        ChessTimerGUI.timer2 = 0; // Player 2 timer runs out
        ChessTimerGUI.isTimer1Active = false;
        ChessTimerGUI.isTimer2Active = true;

        assert board.win() : "Game should end when Player 2's timer reaches zero.";

        assert board.status == GameStatus.WHITE_WIN
                : "Player 1 should be declared the winner when Player 2's timer reaches zero.";

        System.out.println("All timer properties verified successfully.");
    }

    // Abstract TestBoard class for JBMC verification
    private static class TestBoard extends Board {
        public TestBoard() {
            super(0); // Mode is irrelevant for abstract testing
            this.pieceList.clear(); // Clear any default setup
        }

        @Override
        public boolean isValidMove(Move move) {
            if (ChessTimerGUI.timer1 <= 0 && ChessTimerGUI.isTimer1Active) {
                return false; // Player 1 cannot move if their timer is zero
            }
            if (ChessTimerGUI.timer2 <= 0 && ChessTimerGUI.isTimer2Active) {
                return false; // Player 2 cannot move if their timer is zero
            }
            return move.piece.canMove(move.newrow, move.newcol);
        }
    }
}
