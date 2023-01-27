package com.brightstraining.javafxgame.model;

import javafx.scene.image.Image;

public class Bomb {

    public static final double WIDTH = 14;
    public static final double HEIGHT = 14;

    private double x;
    private double y;

    public static Image icon = new Image(Bomb.class.getResource("/img/bomb.png").toExternalForm());

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Bomb(){
        generateSpawn();
    }

    private void generateSpawn(){
        this.x = Math.random() * (Model.WIDTH- Bomb.WIDTH*3) + WIDTH*1;
        this.y =  Math.random() * (Model.HEIGHT- Bomb.HEIGHT*3) + HEIGHT*1;
        if(Model.getCollision().collidesWithAnything(x,y)){
            generateSpawn();
        }
    }

}
