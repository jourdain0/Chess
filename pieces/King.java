package pieces;

import main.Board;
import main.Move;

import java.awt.image.BufferedImage;

public class King extends Piece {

    public King(Board board, int col, int row, boolean isWhite) {
        super(board);
        this.col = col;
        this.row = row;
        this.xPos = col * board.tileSize;
        this.yPos = row * board.tileSize;

        this.isWhite = isWhite;
        this.name = "King";

        this.sprite = sheet.getSubimage(0, isWhite ? 0 : sheetScale, sheetScale, sheetScale).
                getScaledInstance(board.tileSize, board.tileSize, BufferedImage.SCALE_SMOOTH);
    }

    public King(Killed killed, int col, boolean isWhite) {
        super(killed);
        this.col = col;
        this.xPos = col * killed.tileSize;
        this.yPos = 10;

        this.isWhite = isWhite;
        this.name = "King";

        this.sprite = sheet.getSubimage(0, isWhite ? 0 : sheetScale, sheetScale, sheetScale).
                getScaledInstance(killed.tileSize, killed.tileSize, BufferedImage.SCALE_SMOOTH);
    }

    public boolean isValidMovement(int col, int row) {
        if (col < 0 || col > 7 || row < 0 || row > 7) return false;
        return Math.abs((this.col - col) * (this.row - row)) == 1 || Math.abs(this.col - col) +
                Math.abs(this.row - row) == 1 || canCastle(col, row);
    }

    private boolean canCastle(int col, int row) {
        if (this.row == row) {
            if (col == 6) {
                Piece rook = board.getPiece(7, row);
                if (rook != null && rook.isFirstMove && isFirstMove) {
                    return board.getPiece(5, row) == null && board.getPiece(6, row) == null &&
                            !board.checkScanner.isKingChecked(new Move(board, this, 5, row));
                }
            } else if (col == 2) {
                Piece rook = board.getPiece(0, row);
                if (rook != null && rook.isFirstMove && isFirstMove) {
                    return board.getPiece(3, row) == null && board.getPiece(2, row) == null && board.getPiece(1, row) == null &&
                            !board.checkScanner.isKingChecked(new Move(board, this, 3, row));
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
