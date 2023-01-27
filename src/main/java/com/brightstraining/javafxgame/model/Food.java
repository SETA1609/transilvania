package com.brightstraining.javafxgame.model;

import javafx.scene.image.Image;

public class Food {
    public static Image icon = new Image(Food.class.getResource("/img/coin.png").toExternalForm());
    public static final double WIDTH = 12;
    public static final double HEIGHT = 12;
    private double x = Math.random() * (Model.WIDTH - WIDTH * 3) + WIDTH * 3;
    private double y = Math.random() * (Model.HEIGHT - HEIGHT * 3) + HEIGHT * 3;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }


    public void update() {

        generateSpawn();

    }

    private void generateSpawn(){
        this.x = Math.random() * (Model.WIDTH-Food.WIDTH*3) + WIDTH * 3;
        this.y =  Math.random() * (Model.HEIGHT-Food.HEIGHT*3) + HEIGHT * 3;
        if(Model.getCollision().collidesWithAnythingButFood(x,y)){
            generateSpawn();
        }
    }
}