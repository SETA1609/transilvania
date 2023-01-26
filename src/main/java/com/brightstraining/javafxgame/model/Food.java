package com.brightstraining.javafxgame.model;

public class Food {

    public static final double WIDTH = 10;
    public static final double HEIGHT = 10;
    public static final double GROUND_Y = Model.HEIGHT - Food.HEIGHT / 2;
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

        if (x < Food.WIDTH / 2) {
            //spawns too far left
            x += Model.HEIGHT/10;
        }
        else if(x > Model.WIDTH - Food.WIDTH / 2) {
            //spawns too far right
            x -= Model.HEIGHT/10;
        }else if(y < Food.HEIGHT / 2) {
            //spawns too far up
            y += Model.HEIGHT/10;
        }
        else if(y > GROUND_Y) {
            //spawns too far down
            y -= Model.HEIGHT/10;
        }

    }


    public boolean collidesWithPlayer(Player player){
        //Colliding when distance between center less than sum of both radius
        return distance(x,y,player.getX(),player.getY()) < WIDTH/2 + Player.WIDTH/2;
    }

    public double distance(double x1, double y1, double x2, double y2) {
            double ac = Math.abs(y2 - y1);
            double cb = Math.abs(x2 - x1);

            return Math.hypot(ac, cb);
    }

}