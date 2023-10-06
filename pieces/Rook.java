package pieces;

import main.Board;

import java.awt.image.BufferedImage;

public class Rook extends Piece {


    public Rook(Board board, int col, int row, boolean isWhite) {
        super(board);
        this.col = col;
        this.row = row;
        this.xPos = col * board.tileSize;
        this.yPos = row * board.tileSize;

        this.isWhite = isWhite;
        this.name = "Rook";

        this.sprite = sheet.getSubimage(4 * sheetScale, isWhite ? 0 : sheetScale, sheetScale, sheetScale).
                getScaledInstance(board.tileSize, board.tileSize, BufferedImage.SCALE_SMOOTH);
    }

    public Rook(Killed killed, int col, boolean isWhite) {
        super(killed);
        this.col = col;
        this.xPos = col * killed.tileSize;
        this.yPos = 10;

        this.isWhite = isWhite;
        this.name = "Rook";

        this.sprite = sheet.getSubimage(4 * sheetScale, isWhite ? 0 : sheetScale, sheetScale, sheetScale).
                getScaledInstance(killed.tileSize, killed.tileSize, BufferedImage.SCALE_SMOOTH);
    }

    public boolean isValidMovement(int col, int row) {
        if (col < 0 || col > 7 || row < 0 || row > 7) return false;
        return this.col == col || this.row == row;
    }

    public boolean moveCollidesWithPiece(int col, int row) {
        // left
        if (this.col > col) {
            for (int c = this.col - 1; c > col; c--) {
                if (board.getPiece(c, this.row) != null) return true;
            }
        }

        // right
        if (this.col < col) {
            for (int c = this.col + 1; c < col; c++) {
                if (board.getPiece(c, this.row) != null) return true;
            }
        }

        // up
        if (this.row > row) {
            for (int r = this.row - 1; r > row; r--) {
                if (board.getPiece(this.col, r) != null) return true;
            }
        }

        // down
        if (this.row < row) {
            for (int r = this.row + 1; r < row; r++) {
                if (board.getPiece(this.col, r) != null) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
