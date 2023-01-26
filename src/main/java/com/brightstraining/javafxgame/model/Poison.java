package com.brightstraining.javafxgame.model;

public class Poison {
    public static final double WIDTH = 10;
    public static final double HEIGHT = 10;
    private double x = (Math.random() * (Model.WIDTH-Food.WIDTH*2) + WIDTH*2);
    private double y =  (Math.random() * (Model.HEIGHT-HEIGHT*2) + HEIGHT*2);

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

}
