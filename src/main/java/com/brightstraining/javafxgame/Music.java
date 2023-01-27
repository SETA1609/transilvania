package com.brightstraining.javafxgame;

import com.brightstraining.javafxgame.model.Model;
import javafx.scene.media.AudioClip;

import java.util.Objects;

public class Music {

    static AudioClip backGroundMusic = new AudioClip(Music.class.getResource("/audio/Trancyvania.mp3").toExternalForm());
    static AudioClip eatFood = new AudioClip(Objects.requireNonNull(Music.class.getResource("/audio/gameboy.mp3")).toExternalForm());
    static AudioClip gameOverDoh = new AudioClip(Objects.requireNonNull(Music.class.getResource("/audio/looserGewitter.mp3")).toExternalForm());
    static AudioClip gameOverMorning = new AudioClip(Objects.requireNonNull(Music.class.getResource("/audio/Tragedy.mp3")).toExternalForm());

    static boolean hasVolume;

    public static void toggleBackGroundMusic(){
        if(hasVolume) {
            backGroundMusic(MusicFlag.OFF);
            hasVolume = false;
        }else {
            backGroundMusic(MusicFlag.ON);
            hasVolume = true;
        }
    }
    public static void backGroundMusic(MusicFlag musicFlag){

        backGroundMusic.setVolume(0.2);
        backGroundMusic.setCycleCount(AudioClip.INDEFINITE);
        if(musicFlag == MusicFlag.ON) {
            backGroundMusic.play();
            hasVolume = true;
        }
        if(musicFlag == MusicFlag.OFF){
            backGroundMusic.stop();
            hasVolume = false;
        }
        if(Model.isGameOver == true){
            backGroundMusic.stop();
        }
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
