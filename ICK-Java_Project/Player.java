package com.company;

public class Player extends Content implements Movable {
    public final static char PLAYER = '\u263a';

    Board board;
    private boolean endGame = false;

    public Player(Board board) {
        super(PLAYER);
        this.board = board;
    }

    public boolean getEndGame() {
        return endGame;
    }


    @Override
    public void moveUP() {
        Position nextPosition = new Position((board.getCurrentPlayerPosition().getX() - 1), board.getCurrentPlayerPosition().getY());
        if (board.boxInsideBoard(nextPosition)) {
            if (board.nextPositionEmpty(nextPosition)) {
                board.clearBox(board.getCurrentPlayerPosition());
                board.updateBox(board.getPlayer(), nextPosition);
                board.setCurrentPlayerPosition(nextPosition);
            } else if (board.nextPositionBlackHole(nextPosition)) {
                endGame = true;
            } else if (board.nextPositionTreasure(nextPosition)) {
                board.getTreasure().setRandomReward();
                board.getTreasure().calculateTotalReward();
                System.out.println("You got: " + board.getTreasure().getRandomReward() + "$");
                board.clearBox(board.getCurrentPlayerPosition());
                board.updateBox(board.getPlayer(), nextPosition);
                board.setCurrentPlayerPosition(nextPosition);
                board.addTreasure();
            } else if (board.nextPositionEnemy(nextPosition)) {
                board.clearBox(board.getCurrentPlayerPosition());
                board.updateBox(board.getEnemy(), nextPosition);
                board.setCurrentPlayerPosition(nextPosition);
                endGame = true;
            }
        }
    }

    @Override
    public void moveDown() {
        Position nextPosition = new Position((board.getCurrentPlayerPosition().getX() + 1), board.getCurrentPlayerPosition().getY());
        if (board.boxInsideBoard(nextPosition)) {
            if (board.nextPositionEmpty(nextPosition)) {
                board.clearBox(board.getCurrentPlayerPosition());
                board.updateBox(board.getPlayer(), nextPosition);
                board.setCurrentPlayerPosition(nextPosition);
            } else if (board.nextPositionBlackHole(nextPosition)) {
                endGame = true;
            } else if (board.nextPositionTreasure(nextPosition)) {
                board.getTreasure().setRandomReward();
                board.getTreasure().calculateTotalReward();
                System.out.println("You got: " + board.getTreasure().getRandomReward() + "$");
                board.clearBox(board.getCurrentPlayerPosition());
                board.updateBox(board.getPlayer(), nextPosition);
                board.setCurrentPlayerPosition(nextPosition);
                board.addTreasure();
            } else if (board.nextPositionEnemy(nextPosition)) {
                board.clearBox(board.getCurrentPlayerPosition());
                board.updateBox(board.getEnemy(), nextPosition);
                board.setCurrentPlayerPosition(nextPosition);
                endGame = true;
            }
        }
    }

    @Override
    public void moveRight() {
        Position nextPosition = new Position(board.getCurrentPlayerPosition().getX(), (board.getCurrentPlayerPosition().getY() + 1));
        if (board.boxInsideBoard(nextPosition)) {
            if (board.nextPositionEmpty(nextPosition)) {
                board.clearBox(board.getCurrentPlayerPosition());
                board.updateBox(board.getPlayer(), nextPosition);
                board.setCurrentPlayerPosition(nextPosition);
            } else if (board.nextPositionBlackHole(nextPosition)) {
                endGame = true;
            } else if (board.nextPositionTreasure(nextPosition)) {
                board.getTreasure().setRandomReward();
                board.getTreasure().calculateTotalReward();
                System.out.println("You got: " + board.getTreasure().getRandomReward() + "$");
                board.clearBox(board.getCurrentPlayerPosition());
                board.updateBox(board.getPlayer(), nextPosition);
                board.setCurrentPlayerPosition(nextPosition);
                board.addTreasure();
            } else if (board.nextPositionEnemy(nextPosition)) {
                board.clearBox(board.getCurrentPlayerPosition());
                board.updateBox(board.getEnemy(), nextPosition);
                board.setCurrentPlayerPosition(nextPosition);
                endGame = true;
            }
        }
    }

    @Override
    public void moveLeft() {
        Position nextPosition = new Position(board.getCurrentPlayerPosition().getX(), (board.getCurrentPlayerPosition().getY() - 1));
        if (board.boxInsideBoard(nextPosition)) {
            if (board.nextPositionEmpty(nextPosition)) {
                board.clearBox(board.getCurrentPlayerPosition());
                board.updateBox(board.getPlayer(), nextPosition);
                board.setCurrentPlayerPosition(nextPosition);
            } else if (board.nextPositionBlackHole(nextPosition)) {
                endGame = true;
            } else if (board.nextPositionTreasure(nextPosition)) {
                board.getTreasure().setRandomReward();
                board.getTreasure().calculateTotalReward();
                System.out.println("You got: " + board.getTreasure().getRandomReward() + "$");
                board.clearBox(board.getCurrentPlayerPosition());
                board.updateBox(board.getPlayer(), nextPosition);
                board.setCurrentPlayerPosition(nextPosition);
                board.addTreasure();
            } else if (board.nextPositionEnemy(nextPosition)) {
                board.clearBox(board.getCurrentPlayerPosition());
                board.updateBox(board.getEnemy(), nextPosition);
                board.setCurrentPlayerPosition(nextPosition);
                endGame = true;
            }
        }
    }


}
