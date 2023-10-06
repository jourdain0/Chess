package main;

import pieces.Piece;

public class Move {

    int oldCol;
    int oldRow;
    int newCol;
    int newRow;

    Piece piece;
    Piece capture;

    public Move(Board board, Piece piece, int newCol, int newRow) {
        oldCol = piece.col;
        oldRow = piece.row;
        this.newCol = newCol;
        this.newRow = newRow;

        this.piece = piece;
        capture = board.getPiece(newCol, newRow);
    }

    public static void main(String[] args) {

    }
}
