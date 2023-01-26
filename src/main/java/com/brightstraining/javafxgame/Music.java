package com.brightstraining.javafxgame;

import javafx.scene.media.AudioClip;

import java.util.Objects;

import static javafx.util.Duration.INDEFINITE;

public class Music {

    public static void backGroundMusic(){
        AudioClip buzzer = new AudioClip(Music.class.getResource("/audio/Time.mp3").toExternalForm());
        buzzer.setVolume(0.2);
        buzzer.setCycleCount(AudioClip.INDEFINITE);
        buzzer.play();
    }

    public static void eatFoodSound(){
        AudioClip buzzer = new AudioClip(Objects.requireNonNull(Music.class.getResource("/audio/gameboy.mp3")).toExternalForm());
        buzzer.setVolume(0.2);
        buzzer.play();
    }

    public static void gameOverSound(){
        AudioClip buzzer = new AudioClip(Objects.requireNonNull(Music.class.getResource("/audio/Doh.mp3")).toExternalForm());
        buzzer.setVolume(0.15);
        buzzer.play();
    }
}
