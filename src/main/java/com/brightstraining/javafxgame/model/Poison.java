package com.brightstraining.javafxgame.model;

import javafx.scene.image.Image;

public class Poison {

    public static final double WIDTH = 12;
    public static final double HEIGHT = 12;

    private double x = (Math.random() * (Model.WIDTH-Food.WIDTH*2) + WIDTH*2);
    private double y =  (Math.random() * (Model.HEIGHT-HEIGHT*2) + HEIGHT*2);

    public static Image icon = new Image(Poison.class.getResource("/img/bomb.png").toExternalForm());

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

}
