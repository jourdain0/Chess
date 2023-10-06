package main;

import javax.swing.*;
import java.awt.*;

public class Game {

    public static void main(String[] args) {
        // actual board
        JFrame frame = new JFrame();
        frame.getContentPane().setBackground(new Color(200, 200, 175));
        frame.setLayout(new GridBagLayout());
        frame.setMinimumSize(new Dimension(655, 800));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        // JLabel name1 = new JLabel("Black");

        // JLabel name2 = new JLabel("White");

        // main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        Board board = new Board();
        mainPanel.add(board.killed1);
        mainPanel.add(board);
        board.setOpaque(false);
        mainPanel.add(board.killed2);

        // board panel
        mainPanel.setOpaque(false);
        frame.setContentPane(mainPanel);
        frame.setVisible(true);


    }
}
