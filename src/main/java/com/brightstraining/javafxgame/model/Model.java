package com.brightstraining.javafxgame.model;

import com.brightstraining.javafxgame.MusicFlag;

import java.util.ArrayList;
import java.util.List;

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
    private static Collision collision;
    private final Food food;
    public static List<Poison> poisons = new ArrayList<>();

    public Model() {
        this.player = new Player();
        this.food = new Food ();

        this.scoreBoard=new ScoreBoard ();
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

    public static Collision getCollision() {
        return collision;
    }

    public void update(long milliseconds) {
        collision = new Collision(player,poisons,food);
        player.update(milliseconds);


        if(collision.playerCollidesWithFood()) {
            eatFoodSound();
            food.update();
            scoreBoard.update ();
            poisons.add(new Poison());
        }
        if(ScoreBoard.score >0 && collision.playerCollidesWithPoison()){
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