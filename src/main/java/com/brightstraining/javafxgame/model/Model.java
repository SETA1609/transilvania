package com.brightstraining.javafxgame.model;

import javafx.scene.media.AudioClip;

import java.util.Objects;

public class Model {

    public static final double WIDTH = 500;
    public static final double HEIGHT = 500;
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