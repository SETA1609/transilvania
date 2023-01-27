package com.brightstraining.javafxgame.model;

import com.brightstraining.javafxgame.Timer;
import javafx.scene.image.Image;

public class Player {
    public static final String [] PAC_IMAGES = new String [] {"/pacman/pacR.png","/pacman/pacRC.png","/pacman/pacB.png","/pacman/pacBC.png","/pacman/pacL.png","/pacman/pacLC.png","/pacman/pacT.png","/pacman/pacTC.png"};
    public static Image icon;

    public static final double WIDTH = 25;
    public static final double HEIGHT = 25;
    public static final double GROUND_Y = Model.HEIGHT - Player.HEIGHT / 2;

    // coordinates of the center
    private double x = Model.WIDTH / 2 - Player.WIDTH / 2;
    private double y = Model.HEIGHT / 2 - Player.HEIGHT / 2;

    private double speedX = 0.0;
    private double speedY = 0.0;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }


    public void startMovingLeft() {
        speedX = ScoreBoard.score >0 ? -0.0003 - ScoreBoard.score / 100000 : -0.0003;
    }
    public void startMovingRight() {
        speedX = ScoreBoard.score >0 ? 0.0003 + ScoreBoard.score / 100000 : 0.0003;
    }
    public void startMovingDown() {
        this.speedY = ScoreBoard.score >0 ? 0.0003 + ScoreBoard.score / 100000 : 0.0003;
    }
    public void startMovingUp() {
        this.speedY = ScoreBoard.score >0 ? -0.0003 - ScoreBoard.score / 100000 : -0.0003;
    }
    public void stopMovingLeft() {
        if (speedX < 0) {
            speedX = 0;
        }
    }

    public void stopMovingRight() {
        if (speedX > 0) {
            speedX = 0;
        }
    }

    public void stopMovingDown() {
        if (speedY > 0) {
            speedY = 0;
        }
    }

    public void stopMovingUp() {
        if (speedY < 0) {
            speedY = 0;
        }
    }

    public void update(long milliseconds) {

        x += speedX * milliseconds;
        y += speedY * milliseconds;

        if (x < 0) {
            // hit left edge
            x = Model.WIDTH - Player.WIDTH / 2;
        }
        else if(x > Model.WIDTH) {
            // hit right edge
            x = Player.WIDTH / 2;
        }else if(y < 0) {
            // hit top
            y = GROUND_Y;
        }
        else if(y > Model.HEIGHT) {
            // hit bottom
            y = Player.HEIGHT / 2;
        }

        ///////Image Logic
        //Startbild
        if(speedX == 0 && speedY == 0){
            icon = new Image(Player.class.getResource(PAC_IMAGES[0]).toExternalForm());
        }
        //Left
        if(speedX < 0.0){
            if(Timer.getTimestamp()/1000/1000/500 % 2 == 0 ) {
                icon = new Image(Player.class.getResource(PAC_IMAGES[4]).toExternalForm());
            }else {
                icon = new Image(Player.class.getResource(PAC_IMAGES[5]).toExternalForm());
            }
        }
        //Right
        if(speedX > 0) {
            if (Timer.getTimestamp() / 1000 / 1000 / 500 % 2 == 0) {
                icon = new Image(Player.class.getResource(PAC_IMAGES[0]).toExternalForm());
            } else {
                icon = new Image(Player.class.getResource(PAC_IMAGES[1]).toExternalForm());
            }
        }
        //Up
        if(speedY < 0) {
            if (Timer.getTimestamp() / 1000 / 1000 / 500 % 2 == 0) {
                icon = new Image(Player.class.getResource(PAC_IMAGES[6]).toExternalForm());
            } else {
                icon = new Image(Player.class.getResource(PAC_IMAGES[7]).toExternalForm());
            }
        }
        //Down
        if(speedY > 0) {
            if (Timer.getTimestamp() / 1000 / 1000 / 500 % 2 == 0) {
                icon = new Image(Player.class.getResource(PAC_IMAGES[2]).toExternalForm());
            } else {
                icon = new Image(Player.class.getResource(PAC_IMAGES[3]).toExternalForm());
            }
        }
    }
}
