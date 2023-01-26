package com.brightstraining.javafxgame;

import javafx.scene.media.AudioClip;

import java.util.Objects;

import static javafx.util.Duration.INDEFINITE;

public class Music {

    static AudioClip backGroundMusic = new AudioClip(Music.class.getResource("/audio/Trancyvania.mp3").toExternalForm());
    static AudioClip eatFood = new AudioClip(Objects.requireNonNull(Music.class.getResource("/audio/gameboy.mp3")).toExternalForm());
    static AudioClip gameOverDoh = new AudioClip(Objects.requireNonNull(Music.class.getResource("/audio/Doh.mp3")).toExternalForm());
    static AudioClip gameOverMorning = new AudioClip(Objects.requireNonNull(Music.class.getResource("/audio/GoodMorning.mp3")).toExternalForm());

    public static void backGroundMusic(MusicFlag musicFlag){

        backGroundMusic.setVolume(0.2);
        backGroundMusic.setCycleCount(AudioClip.INDEFINITE);
        if(musicFlag == MusicFlag.ON) {
            backGroundMusic.play();
        }
        if(musicFlag == MusicFlag.OFF){
            backGroundMusic.stop();
        }
    }
    public static void backGroundMusicStop(){

    }

    public static void eatFoodSound(){

        eatFood.setVolume(0.2);
        eatFood.play();
    }

    public static void gameOverSound(){

        gameOverDoh.setVolume(0.15);
        gameOverDoh.play();

        gameOverMorning.setVolume(0.15);
        gameOverMorning.play();
    }
}
