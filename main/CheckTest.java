package main;

import main.Board;
import main.Move;
import pieces.King;
import pieces.Rook;

public class CheckTest {
    public static void main(String[] args) {
        Board board = new Board(0,true);
        testKingInCheck(board);
    }

    public static void testKingInCheck(Board board) {
        board.pieceList.clear();

        King whiteKing = new King(board, 7, 4, true);
        board.pieceList.add(whiteKing);

        Rook blackRook = new Rook(board, 7, 7, false);
        board.pieceList.add(blackRook);  //threatens king horizontally

        //JMBC
        assert board.checkAttacked(7, 4, true) : "White king should be in check";
        //verify that King is being attcked
        Move invalidMove = new Move(board, whiteKing, 6, 4);
        assert !board.isValidMove(invalidMove) : "Invalid move should not be allowed";
        //makes sure invalid moves are not permitted
        Move validMove = new Move(board, whiteKing, 6, 5);
        assert board.isValidMove(validMove) : "Valid move should be allowed";

        System.out.println("Test passed: King in check is correctly handled.");
    }

}
