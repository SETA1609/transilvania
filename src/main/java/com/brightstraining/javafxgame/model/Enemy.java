package com.brightstraining.javafxgame.model;

public class Enemy {

    public static final long WIDTH = 40;
    public static final long HEIGHT = 15;
    public static final long GROUND_Y = Model.HEIGHT / 2;

    // coordinates of the center
    private long x = Model.WIDTH / 2 - Enemy.WIDTH / 2;
    private long y = Model.HEIGHT / 2 - Enemy.HEIGHT / 2;

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

        if (y > GROUND_Y) {
            // hit ground
            y = GROUND_Y;
            speedY = 0;
        }
        else {
            // player is in the air, accelerate towards ground
            speedY += milliseconds * 0.000000002;
        }

        if (x < Enemy.WIDTH / 2) {
            // hit left edge
            x = Enemy.WIDTH / 2;
        }
        else if(x > Model.WIDTH - Enemy.WIDTH / 2) {
            // hit right edge
            x = Model.WIDTH - Enemy.WIDTH / 2;
        }
    }
}
