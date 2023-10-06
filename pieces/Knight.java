package pieces;

import main.Board;

import java.awt.image.BufferedImage;

public class Knight extends Piece {

    public Knight(Board board, int col, int row, boolean isWhite) {
        super(board);
        this.col = col;
        this.row = row;
        this.xPos = col * board.tileSize;
        this.yPos = row * board.tileSize;

        this.isWhite = isWhite;
        this.name = "Knight";

        this.sprite = sheet.getSubimage(3 * sheetScale, isWhite ? 0 : sheetScale, sheetScale, sheetScale).
                getScaledInstance(board.tileSize, board.tileSize, BufferedImage.SCALE_SMOOTH);
    }

    public Knight(Killed killed, int col, boolean isWhite) {
        super(killed);
        this.col = col;
        this.xPos = col * killed.tileSize;
        this.yPos = 10;

        this.isWhite = isWhite;
        this.name = "Knight";

        this.sprite = sheet.getSubimage(3 * sheetScale, isWhite ? 0 : sheetScale, sheetScale, sheetScale).
                getScaledInstance(killed.tileSize, killed.tileSize, BufferedImage.SCALE_SMOOTH);
    }


    public boolean isValidMovement(int col, int row) {
        if (col < 0 || col > 7 || row < 0 || row > 7) return false;
        return Math.abs(col - this.col) * Math.abs(row - this.row) == 2;
    }

    public static void main(String[] args) {

    }
}
