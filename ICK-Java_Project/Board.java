package com.company;

public class Board {
    private final Box[][] boxes;
    private final int rows;
    private final int cols;
    private final Player player = new Player(this);
    private Position currentPlayerPosition;
    private final BlackHole blackHole = new BlackHole();
    private final Treasure treasure = new Treasure();
    private final Enemy enemy = new Enemy(this);
    private Position currentEnemyPosition;


    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Player getPlayer() {
        return player;
    }

    public Position getCurrentPlayerPosition() {
        return currentPlayerPosition;
    }

    public void setCurrentPlayerPosition(Position currentPlayerPosition) {
        this.currentPlayerPosition = currentPlayerPosition;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public Position getCurrentEnemyPosition() {
        return currentEnemyPosition;
    }

    public void setCurrentEnemyPosition(Position currentEnemyPosition) {
        this.currentEnemyPosition = currentEnemyPosition;
    }

    public Treasure getTreasure() {
        return treasure;
    }

    public Board(int rows, int cols) {
        boxes = new Box[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                boxes[row][col] = new Box();
            }
        }
        this.rows = rows;
        this.cols = cols;
    }

    public Box getBox(Position position) {
        return boxes[position.getX()][position.getY()];
    }

    public Box getBox(int i, int j) {
        return boxes[i][j];
    }

    public void updateBox(Content content, Position position) {
        if (content == null) {
            clearBox(position);
        } else if (content instanceof Player) {
            getBox(position).setContent(player);
        } else if (content instanceof Obstacle) {
            getBox(position).setContent(content);
        } else if (content instanceof BlackHole) {
            getBox(position).setContent(content);
        } else if (content instanceof Treasure) {
            getBox(position).setContent(content);
        } else if (content instanceof Enemy) {
            getBox(position).setContent(content);
        }
    }

    public void clearBox(Position position) {
        getBox(position).clear();
    }

    public boolean boxInsideBoard(Position position) {
        return (position.getX() > -1 && position.getX() < rows) &&
                (position.getY() > -1 && position.getY() < cols);
    }

    public boolean nextPositionEmpty(Position position) {
        return getBox(position).isEmpty();
    }

    public boolean nextPositionBlackHole(Position position) {
        if (!nextPositionEmpty(position)) {
            return getBox(position).getContent().getSymbol() == BlackHole.BLACK_HOLE;
        } else return false;
    }

    public boolean nextPositionTreasure(Position position) {
        if (!nextPositionEmpty(position)) {
            return getBox(position).getContent().getSymbol() == Treasure.TREASURE;
        } else return false;
    }

    public boolean nextPositionEnemy(Position position) {
        if (!nextPositionEmpty(position)) {
            return getBox(position).getContent().getSymbol() == Enemy.ENEMY;
        } else return false;
    }

    public boolean nextPositionPlayer(Position position) {
        if (!nextPositionEmpty(position)) {
            return getBox(position).getContent().getSymbol() == Player.PLAYER;
        } else return false;
    }

    public void addPlayer(Position position) {
        updateBox(player, position);
        currentPlayerPosition = position;
    }

    public void addObstacle(Position position) {
        updateBox(new Obstacle(), position);
    }

    public void addBlackHole() {
        while (true) {
            blackHole.setBhPosition(rows, cols);
            if (getBox(blackHole.getBhPosition()).isEmpty()) {
                updateBox(blackHole, blackHole.getBhPosition());
                break;
            }
        }
    }

    public void addEnemy() {
        while (true) {
            enemy.setStartingPosition(rows, cols);
            if (getBox(enemy.getStartingPosition()).isEmpty()) {
                updateBox(enemy, enemy.getStartingPosition());
                currentEnemyPosition = enemy.getStartingPosition();
                break;
            }
        }
    }

    public void addTreasure() {
        while (true) {
            treasure.setTreasurePosition(rows, cols);
            if (getBox(treasure.getTreasurePosition()).isEmpty()) {
                updateBox(treasure, treasure.getTreasurePosition());
                break;
            }
        }
    }
}
