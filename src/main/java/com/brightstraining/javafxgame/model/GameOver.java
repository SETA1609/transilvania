package com.brightstraining.javafxgame.model;

public class GameOver {
    public String gameOver="Game Over \n Where did you learn to fly?";
    private int x;
    private int y;

    public String getGameOver() {
        return gameOver;
    }

    public void setGameOver(String gameOver) {
        this.gameOver = gameOver;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Game Over \n Where did you \n Learn to fly?";
    }
}
