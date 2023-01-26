package com.brightstraining.javafxgame.model;

import com.brightstraining.javafxgame.MusicFlag;
import javafx.scene.media.AudioClip;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.brightstraining.javafxgame.Music.*;

public class Model {
    public static boolean isGameOver = false;

    public static final double WIDTH = 800;

    public static final double HEIGHT = 500;


    public static final double ROWS = 20;
    public static final double COLUMNS = ROWS;
    public static final double SQUSIZE = WIDTH/ROWS;


    private ScoreBoard scoreBoard;

    private final Player player;

    private final Food food;
    public static List<Poison> poisons = new ArrayList<>();
    public Model() {
        this.player = new Player();
        this.food = new Food ();

        this.scoreBoard=new ScoreBoard ();
        //buzzer = new AudioClip(Objects.requireNonNull(getClass().getResource("/audio/gameboy.mp3")).toExternalForm());
        //buzzer.setVolume(0.1);
    }

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }
    public Food getFood() {
        return food;
    }


    public Player getPlayer() {
        return player;
    }

    public void update(long milliseconds) {
        player.update(milliseconds);
        //if (player.isMoving()){

        //}
        if(Collision.collidesWithPlayer(player,food)) {
            eatFoodSound();
            food.update();
            scoreBoard.update ();
            poisons.add(new Poison());
        }
        if(ScoreBoard.score >0 && Collision.collidesWithPlayer(player,poisons)){
            backGroundMusic(MusicFlag.OFF);
            gameOverSound();
            player.stopMovingDown();
            player.stopMovingLeft();
            player.stopMovingRight();
            player.stopMovingUp();
            isGameOver = true;
            //Was auch immer bei GameOver
        }
    }

    public List<Poison> getPoisons() {
        return poisons;
    }
}