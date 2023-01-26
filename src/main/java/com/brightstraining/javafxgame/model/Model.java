package com.brightstraining.javafxgame.model;

public class Model {

    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;

    private Player player;
    private Food food;

    public Food getFood() {
        return food;
    }

    public Model() {
        this.player = new Player();
        this.food = new Food ();
    }

    public Player getPlayer() {
        return player;
    }

    public void update(long milliseconds) {
        player.update(milliseconds);
        food.update(this.player);
    }



}