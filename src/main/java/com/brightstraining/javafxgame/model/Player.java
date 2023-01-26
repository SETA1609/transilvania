package com.brightstraining.javafxgame.model;

public class Player {

    public static final long WIDTH = 25;
    public static final long HEIGHT = 25;
    public static final long GROUND_Y = Model.HEIGHT - Player.HEIGHT / 2;

    // coordinates of the center
    private long x = Model.WIDTH / 2 - Player.WIDTH / 2;
    private long y = Model.HEIGHT / 2 - Player.HEIGHT / 2;

    private double speedX = 0;
    private double speedY = 0;

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public void jump() {
        // can only jump when standing on the ground
        if (y == GROUND_Y) {
            speedY = -0.0008;
        }
    }

    public void startMovingLeft() {
        if(speedX == 0){
            speedX = -0.0003;
        }
    }
    public void stopMovingLeft() {
        if (speedX < 0) {
            speedX = 0;
        }
    }
    public void startMovingRight() {

        if(speedX == 0){
            speedX = 0.0003;
        }
    }
    public void stopMovingRight() {
        if (speedX > 0) {
            speedX = 0;
        }
    }

    public void update(long milliseconds) {

        x += speedX * milliseconds;
        y += speedY * milliseconds;

        /*if (y > GROUND_Y) {
            // hit ground
            y = GROUND_Y;
            speedY = 0;
        }
        else {
            // player is in the air, accelerate towards ground
            speedY += milliseconds * 0.000000002;
        }*/

        if (x < Player.WIDTH / 2) {
            // hit left edge
            x = Model.WIDTH - Player.WIDTH / 2;
        }
        else if(x > Model.WIDTH - Player.WIDTH / 2) {
            // hit right edge
            x = Player.WIDTH / 2;
        }else if(y < Player.HEIGHT / 2) {
            // hit top
            y = GROUND_Y;
        }
        else if(y > GROUND_Y) {
            // hit bottom
            y = Player.HEIGHT / 2;
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

    public void startMovingDown() {
        if(this.speedY == 0){
            this.speedY = 0.0003;
        }
    }

    public void startMovingUp() {
        if (this.speedY == 0) {
            this.speedY = -0.0003;
        }
    }
}
