package com.company;

import java.awt.*;
import javax.swing.*;

public class BoardPanel extends JPanel {
    private final Board board;

    private final int width;
    private final int height;

    private final int boxWidth;
    private final int boxHeight;

    public BoardPanel(Board board, int boxSize) {
        this.board = board;

        width = boxSize * board.getCols();
        height = boxSize * board.getRows();

        boxWidth = width / board.getCols();
        boxHeight = height / board.getRows();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width + 2, height + 2);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.black);

        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getCols(); j++) {
                int boxX = j * boxWidth;
                int boxY = i * boxHeight;

                g.drawRect(boxX, boxY, boxWidth, boxHeight);

                if (board.getBox(i,j).getContent() == null){
                    g.drawString("", boxX + boxWidth / 2, boxY + boxHeight / 2);
                }else {
                    String content = board.getBox(i, j).toString();
                    g.drawString(content, boxX + boxWidth / 2, boxY + boxHeight / 2);
                }
            }
        }

    }

    public void updateDrawing() {
        repaint();
    }
}
