package com.brightstraining.javafxgame.model;

import javafx.scene.image.Image;

public class Poison {
    public static final double WIDTH = 13;
    public static final double HEIGHT = 13;
    private double x = (Math.random() * (Model.WIDTH-Food.WIDTH*2) + WIDTH*2);
    private double y =  (Math.random() * (Model.HEIGHT-HEIGHT*2) + HEIGHT*2);

    private static final String [] POISON_IMAGE = new String[]{};
    public Image poisonImage;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

}
