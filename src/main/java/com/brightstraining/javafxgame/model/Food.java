package com.brightstraining.javafxgame.model;

import javafx.scene.image.Image;

public class Food {
    public static Image icon = new Image(Food.class.getResource("/img/coin.png").toExternalForm());
    public static final double WIDTH = 12;
    public static final double HEIGHT = 12;
    private double x = ((Math.random() * (Model.WIDTH - WIDTH * 2)) + WIDTH * 2);
    private double y = ((Math.random() * (Model.HEIGHT - HEIGHT * 2)) + HEIGHT * 2);

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }


    public void update() {

        x = ((Math.random() * (Model.WIDTH - WIDTH * 2)) + WIDTH * 2);
        y = ((Math.random() * (Model.HEIGHT - HEIGHT * 2)) + HEIGHT * 2);
    }
}