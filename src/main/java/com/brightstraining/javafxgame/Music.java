package com.brightstraining.javafxgame;

import javafx.scene.media.AudioClip;

public class Music {

    public static void backGroundMusic(){
        AudioClip buzzer = new AudioClip(Music.class.getResource("/audio/Time.mp3").toExternalForm());
        buzzer.play();
    }
}
