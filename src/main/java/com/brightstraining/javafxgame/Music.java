package com.brightstraining.javafxgame;

import javafx.scene.media.AudioClip;

import java.util.Objects;

public class Music {

    public static void backGroundMusic(){
        AudioClip buzzer = new AudioClip(Music.class.getResource("/audio/Time.mp3").toExternalForm());
        buzzer.setVolume(0.1);
        buzzer.play();
    }

    public static void eatFoodSound(){
        AudioClip buzzer = new AudioClip(Objects.requireNonNull(Music.class.getResource("/audio/gameboy.mp3")).toExternalForm());
        buzzer.setVolume(0.1);
        buzzer.play();
    }
}
