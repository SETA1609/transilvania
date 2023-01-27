package com.brightstraining.javafxgame.model;

import javafx.scene.image.Image;

public class Poison {

    public static final double WIDTH = 14;
    public static final double HEIGHT = 14;

    private double x;
    private double y;

    public static Image icon = new Image(Poison.class.getResource("/img/bomb.png").toExternalForm());

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Poison(){
        generateSpawn();
    }

    private void generateSpawn(){
        this.x = Math.random() * (Model.WIDTH-Poison.WIDTH*3) + WIDTH*1;
        this.y =  Math.random() * (Model.HEIGHT-Poison.HEIGHT*3) + HEIGHT*1;
        if(Model.getCollision().collidesWithAnything(x,y)){
            generateSpawn();
        }
    }

}
