package com.brightstraining.javafxgame.model;

public class Player {

    public static final double WIDTH = 25;
    public static final double HEIGHT = 25;
    public static final double GROUND_Y = Model.HEIGHT - Player.HEIGHT / 2;

    // coordinates of the center
    private double x = Model.WIDTH / 2 - Player.WIDTH / 2;
    private double y = Model.HEIGHT / 2 - Player.HEIGHT / 2;

    private double speedX = 0;
    private double speedY = 0;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }


    public void startMovingLeft() {

            speedX = -0.0003;

    }
    public void stopMovingLeft() {
        if (speedX < 0) {
            speedX = 0;
        }
    }
    public void startMovingRight() {


            speedX = 0.0003;

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

            this.speedY = 0.0003;

    }

    public void startMovingUp() {

            this.speedY = -0.0003;

    }
}
