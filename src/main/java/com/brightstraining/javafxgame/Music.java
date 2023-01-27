package com.brightstraining.javafxgame;

import com.brightstraining.javafxgame.model.Model;
import javafx.scene.media.AudioClip;

import java.util.Objects;

public class Music {

    static AudioClip backGroundMusic = new AudioClip(Music.class.getResource("/audio/Trancyvania.mp3").toExternalForm());
    static AudioClip eatFood = new AudioClip(Objects.requireNonNull(Music.class.getResource("/audio/gameboy.mp3")).toExternalForm());
    static AudioClip gameOverThunder = new AudioClip(Objects.requireNonNull(Music.class.getResource("/audio/looserGewitter.mp3")).toExternalForm());
    static AudioClip gameOverMusic = new AudioClip(Objects.requireNonNull(Music.class.getResource("/audio/Tragedy.mp3")).toExternalForm());

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
        if(musicFlag == MusicFlag.ON) {
            backGroundMusic.setVolume(0.2);
            backGroundMusic.setCycleCount(AudioClip.INDEFINITE);
            backGroundMusic.play();
            hasVolume = true;
        }
        if(musicFlag == MusicFlag.OFF){
            backGroundMusic.stop();
            hasVolume = false;
        }
    }

    public static void eatFoodSound(){
        eatFood.setVolume(0.2);
        eatFood.play();
    }

    public static void gameOverMusic(MusicFlag musicFlag){
        if(musicFlag == MusicFlag.ON) {

            gameOverMusic.setVolume(0.2);
            gameOverMusic.setCycleCount(AudioClip.INDEFINITE);
            gameOverMusic.play();
            hasVolume = true;
        }
        if(musicFlag == MusicFlag.OFF){
            gameOverMusic.stop();
            hasVolume = false;
        }
    }

    public static void eatBombSound() {
        gameOverThunder.setVolume(0.15);
        gameOverThunder.play();
    }

    public static void toggleGameOverMusic() {
        if(hasVolume) {
            gameOverMusic(MusicFlag.OFF);
            hasVolume = false;
        }else {
            gameOverMusic(MusicFlag.ON);
            hasVolume = true;
        }
    }
}
