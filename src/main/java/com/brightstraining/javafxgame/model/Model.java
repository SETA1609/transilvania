package com.brightstraining.javafxgame.model;

import javafx.scene.media.AudioClip;

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
        if(food.collidesWithPlayer(player)) {
            AudioClip buzzer = new AudioClip(getClass().getResource("/audio/gameboy.mp3").toExternalForm());
            buzzer.play();
            food.update(this.player);
        }
    }



}