package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardInitialization {

    public void createBoard() {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Initialize table: ");
            String boardInput = in.nextLine();
            if (validBoardInput(boardInput)) {
                String[] tempTokens = boardInput.split(",");
                ArrayList<Integer> tableTokens = new ArrayList<>();
                for (String tempToken : tempTokens) {
                    tableTokens.add(Integer.parseInt(tempToken.trim()));
                }

                Board board = new Board(tableTokens.get(0), tableTokens.get(1));
                board.addPlayer(new Position(tableTokens.get(2), tableTokens.get(3)));
                while (true) {
                    System.out.print("Insert Obstacle: ");
                    String obstacle = in.nextLine();
                    if (!obstacle.equals("")) {
                        if (validObstacleInput(obstacle, tableTokens.get(0), tableTokens.get(1),
                                tableTokens.get(2), tableTokens.get(3))) {
                            tempTokens = obstacle.split(",");
                            ArrayList<Integer> obstacleTokens = new ArrayList<>();
                            for (String tempToken : tempTokens) {
                                obstacleTokens.add(Integer.parseInt(tempToken.trim()));
                            }
                            board.addObstacle(new Position(obstacleTokens.get(0), obstacleTokens.get(1)));
                        }
                    } else {
                        break;
                    }
                }
                board.addBlackHole();
                board.addTreasure();
                board.addEnemy();
                new WindowDisplay(board);
                break;
            }
        }
    }


    private boolean validBoardInput(String userInput) {
        if (!userInput.equals("")) {
            userInput = userInput.trim();
            if (userInput.matches("\\d+, \\d+, \\d+, \\d+") ||
                    userInput.matches("\\d+,\\d+,\\d+,\\d+")) {
                String[] tokens = userInput.split(",");
                if (Integer.parseInt(tokens[2].trim()) >= Integer.parseInt(tokens[0].trim())
                        || Integer.parseInt(tokens[3].trim()) >= Integer.parseInt(tokens[1].trim())) {
                    System.out.println("Cannot insert player outside of board boundaries, try again: ");
                    return false;
                } else {
                    return true;
                }
            } else {
                System.out.println("Invalid input, try again: ");
                return false;
            }
        } else {
            System.out.println("Input not provided, try again: ");
            return false;
        }
    }

    private boolean validObstacleInput(String userInput, int boardToken1, int boardToken2, int playerToken1, int playerToken2) {
        userInput = userInput.trim();
        if (userInput.matches("\\d+, \\d+") || userInput.matches("\\d+,\\d+")) {
            String[] tokens = userInput.split(",");
            if (Integer.parseInt(tokens[0].trim()) >= boardToken1 || Integer.parseInt(tokens[1].trim()) >= boardToken2) {
                System.out.println("Cannot insert obstacle outside of board boundaries, try again: ");
                return false;
            } else {
                if (Integer.parseInt(tokens[0].trim()) == playerToken1
                        && Integer.parseInt(tokens[1].trim()) == playerToken2) {
                    System.out.println("Cannot insert obstacle in same box as player, try again: ");
                } else {
                    return true;
                }
            }
        } else {
            System.out.println("Invalid input, try again: ");
            return false;
        }

        return false;
    }

}
