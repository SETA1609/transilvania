package com.brightstraining.javafxgame.model;

public class Poison {
    public static final double WIDTH = 10;
    public static final double HEIGHT = 10;
    private double x = (long) ((Math.random() * (Model.WIDTH-15)) + 15);
    private double y = (long) ((Math.random() * (Model.HEIGHT-15)) + 15);

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }


    public void update() {

        x = (long) ((Math.random() * (Model.WIDTH-Food.WIDTH*2)) + WIDTH*2);
        y = (long) ((Math.random() * (Model.HEIGHT-HEIGHT*2)) + HEIGHT*2);
    }
}
