package pieces;

import main.Board;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Killed extends JPanel {

    public final int tileSize = 42;
    public final int cols = 15;
    private int current = 0;
    public ArrayList<Piece> killList = new ArrayList<>();

    Board board;

    public Killed() {
        this.setPreferredSize(new Dimension(cols * tileSize, 40));
    }

    public void addKill(Piece kill) {
        if (kill.name.equals("Pawn")) killList.add(new Pawn(this, current, kill.isWhite));
        else if (kill.name.equals("Rook")) killList.add(new Rook(this, current, kill.isWhite));
        else if (kill.name.equals("Knight")) killList.add(new Knight(this, current, kill.isWhite));
        else if (kill.name.equals("Bishop")) killList.add(new Bishop(this, current, kill.isWhite));
        else if (kill.name.equals("Queen")) killList.add(new Queen(this, current, kill.isWhite));
        else if (kill.name.equals("King")) killList.add(new King(this, current, kill.isWhite));
        current++;
        SwingUtilities.windowForComponent(this).repaint();
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        /* paint board
        for (int c = 0; c < cols; c++) {
            g2d.setColor(Color.darkGray);
            g2d.fillRect(c * tileSize, tileSize, tileSize, tileSize);
        } */

        // paint pieces
        for (Piece piece : killList) {
            piece.paint(g2d);
        }
    }

    public static void main(String[] args) {

    }
}
