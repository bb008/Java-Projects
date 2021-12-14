package com.company;

import java.util.Random;

public class Treasure extends Content{
    public final static char TREASURE = '\u0024';

    public final static int SILVER_AWARD = 100;
    public final static int GOLDEN_AWARD = 500;
    public final static int PLATINUM_AWARD = 1000;
    public final static int DIAMOND_AWARD = 5000;

    private Position treasurePosition;

    private int randomReward;
    private int totalReward;

    public Treasure(){
        super(TREASURE);
    }

    public int getTotalReward() {
        return totalReward;
    }

    public int getRandomReward() {
        return randomReward;
    }

    public void setRandomReward(){
        int random = new Random().nextInt(100);
        if (random >= 0 && random < 50) {
            randomReward = SILVER_AWARD;
        } else if (random >= 50 && random < 75) {
            randomReward = GOLDEN_AWARD;
        } else if (random >= 75 && random < 90) {
            randomReward = PLATINUM_AWARD;
        } else {
            randomReward = DIAMOND_AWARD;
        }
    }

    public void calculateTotalReward() {
        totalReward += randomReward;
    }

    public void setTreasurePosition(int x, int y) {
        Random generator1 = new Random();
        int row = generator1.nextInt(x);
        int col = generator1.nextInt(y);
        treasurePosition = new Position(row,col);
    }

    public Position getTreasurePosition() {
        return treasurePosition;
    }

}
