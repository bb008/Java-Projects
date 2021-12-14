package com.company;

import java.util.Random;

public class BlackHole extends Content {
    public final static char BLACK_HOLE = '\u26ab';
    public Position bhPosition;
    public BlackHole(){
        super((BLACK_HOLE));
    }

    public void setBhPosition(int x, int y) {
        Random generator1 = new Random();
        int row = generator1.nextInt(x);
        int col = generator1.nextInt(y);
        bhPosition = new Position(row,col);
    }

    public Position getBhPosition() {
        return bhPosition;
    }
}
