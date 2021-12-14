package com.company;

public abstract class Content {
    private final char symbol;

    protected Content(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public String toString() {
        return "" + symbol;
    }

}
