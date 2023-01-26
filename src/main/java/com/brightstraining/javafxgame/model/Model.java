package com.brightstraining.javafxgame.model;

import javafx.scene.media.AudioClip;

import java.util.Objects;

public class Model {

    public static final double WIDTH = 1000;
    public static final double HEIGHT = 1000;

    public static final int ROWS = 20;
    public static final int COLUMNS = ROWS;
    public static final int SQUSIZE = (int) WIDTH/ROWS;
    private final AudioClip buzzer;

    private final Player player;
    private final Food food;

    public Food getFood() {
        return food;
    }

    public Model() {
        this.player = new Player();
        this.food = new Food ();
        buzzer = new AudioClip(Objects.requireNonNull(getClass().getResource("/audio/gameboy.mp3")).toExternalForm());
    }

    public Player getPlayer() {
        return player;
    }

    public void update(long milliseconds) {
        player.update(milliseconds);
        if(Collision.collidesWithPlayer(player,food)) {
            buzzer.play();
            food.update();
        }
    }
}