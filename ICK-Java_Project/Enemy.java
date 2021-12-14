package com.company;

import java.util.Random;

public class Enemy extends Content implements Movable {
    public final static char ENEMY = '\u2620';
    Board board;
    private Position startingPosition;
    private boolean endGame = false;

    public Enemy(Board board) {
        super(ENEMY);
        this.board = board;
    }

    public void setStartingPosition(int x, int y) {
        Random generator1 = new Random();
        int row = generator1.nextInt(x);
        int col = generator1.nextInt(y);
        startingPosition = new Position(row, col);
    }

    public Position getStartingPosition() {
        return startingPosition;
    }

    public boolean getEndGame() {
        return endGame;
    }

    @Override
    public void moveUP() {
        Position nextPosition = new Position((board.getCurrentEnemyPosition().getX() - 1), board.getCurrentEnemyPosition().getY());
        if (board.boxInsideBoard(nextPosition)) {
            if (board.nextPositionEmpty(nextPosition)) {
                board.clearBox(board.getCurrentEnemyPosition());
                board.updateBox(board.getEnemy(), nextPosition);
                board.setCurrentEnemyPosition(nextPosition);
            } else if (board.nextPositionPlayer(nextPosition)) {
                endGame = true;
            }
        }
    }

    @Override
    public void moveDown() {
        Position nextPosition = new Position((board.getCurrentEnemyPosition().getX() + 1), board.getCurrentEnemyPosition().getY());
        if (board.boxInsideBoard(nextPosition)) {
            if (board.nextPositionEmpty(nextPosition)) {
                board.clearBox(board.getCurrentEnemyPosition());
                board.updateBox(board.getEnemy(), nextPosition);
                board.setCurrentEnemyPosition(nextPosition);
            } else if (board.nextPositionPlayer(nextPosition)) {
                endGame = true;
            }
        }
    }

    @Override
    public void moveRight() {
        Position nextPosition = new Position(board.getCurrentEnemyPosition().getX(), (board.getCurrentEnemyPosition().getY() + 1));
        if (board.boxInsideBoard(nextPosition)) {
            if (board.nextPositionEmpty(nextPosition)) {
                board.clearBox(board.getCurrentEnemyPosition());
                board.updateBox(board.getEnemy(), nextPosition);
                board.setCurrentEnemyPosition(nextPosition);
            } else if (board.nextPositionPlayer(nextPosition)) {
                endGame = true;
            }
        }
    }

    @Override
    public void moveLeft() {
        Position nextPosition = new Position(board.getCurrentEnemyPosition().getX(), (board.getCurrentEnemyPosition().getY() - 1));
        if (board.boxInsideBoard(nextPosition)) {
            if (board.nextPositionEmpty(nextPosition)) {
                board.clearBox(board.getCurrentEnemyPosition());
                board.updateBox(board.getEnemy(), nextPosition);
                board.setCurrentEnemyPosition(nextPosition);
            } else if (board.nextPositionPlayer(nextPosition)) {
                endGame = true;
            }
        }
    }

    public void randomEnemyMovement() {
        int random = new Random().nextInt(100);
        if (random >= 0 && random < 25) {
            moveUP();
        } else if (random >= 25 && random < 50) {
            moveDown();
        } else if (random >= 50 && random < 75) {
            moveRight();
        } else {
            moveLeft();
        }
    }

}
