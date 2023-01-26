package com.brightstraining.javafxgame.model;

public class Food {

    public static final double WIDTH = 10;
    public static final double HEIGHT = 10;
    public static final double GROUND_Y = Model.HEIGHT - Food.HEIGHT/2;
    private double x = Model.WIDTH/10;
    private double y = Model.HEIGHT/7;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }


    public void update() {

            x = (long) ((Math.random ()*Model.WIDTH)+WIDTH*2);
            y = (long) ((Math.random ()* Model.HEIGHT)+HEIGHT*2);

        if (x < Food.WIDTH) {
            //spawns too far left
            x += Model.HEIGHT/10;
        }
        else if(x > Model.WIDTH - Food.WIDTH) {
            //spawns too far right
            x -= Model.HEIGHT/10;
        }else if(y < Food.HEIGHT) {
            //spawns too far up
            y += Model.HEIGHT/10;
        }
        else if(y > Model.HEIGHT - Food.HEIGHT) {
            //spawns too far down
            y -= Model.HEIGHT/10;
        }
    }
}