package com.brightstraining.javafxgame.model;

public class Model {

    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;

    private Player player;
    private Enemy enemy;

    public Enemy getEnemy(){
        return this.enemy;
    }

    public Model() {
        this.player = new Player();
        this.enemy = new Enemy();
    }

    public Player getPlayer() {
        return player;
    }

    public void update(long milliseconds) {
        player.update(milliseconds);
    }
}
