package com.company;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WindowDisplay extends JFrame implements KeyListener {
    private final BoardPanel pnlBoard;
    private final Board board;

    public WindowDisplay(Board board) {
        this("My Game", board);
    }

    public WindowDisplay(String title, Board board) {
        this.board = board;
        setTitle(title);
        Container content = getContentPane();
        content.setLayout(new BorderLayout());
        int boxSize = 50;
        pnlBoard = new BoardPanel(board, boxSize);
        content.add(pnlBoard, BorderLayout.CENTER);

        addKeyListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(100, 200);
        pack();
        setVisible(true);
        moveEnemy();
    }

    public void update() {
        pnlBoard.updateDrawing();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            board.getPlayer().moveRight();
            if (board.getPlayer().getEndGame()) {
                endGame();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            board.getPlayer().moveLeft();
            if (board.getPlayer().getEndGame()) {
                endGame();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            board.getPlayer().moveDown();
            if (board.getPlayer().getEndGame()) {
                endGame();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            board.getPlayer().moveUP();
            if (board.getPlayer().getEndGame()) {
                endGame();
            }
        }
        update();
    }

    public void moveEnemy() {
        while (true) {
            try {
                Thread.sleep(300);
                board.getEnemy().randomEnemyMovement();
                if (board.getEnemy().getEndGame()) {
                    endGame();
                    break;
                }
                update();
            } catch (Exception ignored) {
                break;
            }

        }
    }


    public void endGame() {
        setVisible(false);
        dispose();
        System.out.println("\nYour total reward: " + board.getTreasure().getTotalReward() + "$");
    }


}