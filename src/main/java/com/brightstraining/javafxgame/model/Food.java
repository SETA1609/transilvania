package com.brightstraining.javafxgame.model;

public class Food {
    private int Score;
    public static final long WIDTH = 10;
    public static final long HEIGHT = 10;
    public static final long GROUND_Y = Model.HEIGHT - Food.HEIGHT / 2;
    private long x = Model.WIDTH/10;
    private long y = Model.HEIGHT/7;

    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public long getY() {
        return y;
    }

    public void setY(long y) {
        this.y = y;
    }
    public void update(Player player) {

            x = (long) ((Math.random ()*Model.WIDTH)+WIDTH*2);
            y = (long) ((Math.random ()* Model.HEIGHT)+HEIGHT*2);

        if (x < Food.WIDTH / 2) {
            // hit left edge
            x = Food.WIDTH - Food.WIDTH / 2;
        }
        else if(x > Model.WIDTH - Food.WIDTH / 2) {
            // hit right edge
            x = Food.WIDTH / 2;
        }else if(y < Food.HEIGHT / 2) {
            // hit top
            y = GROUND_Y;
        }
        else if(y > GROUND_Y) {
            // hit bottom
            y = Food.HEIGHT / 2;
        }

    }
    //Methode, die der Axis check

    public boolean collidesWithPlayer(Player player){
        //Colliding when distance between center less than sum of radius
        return distance(x,y,player.getX(),player.getY()) < WIDTH/2 + Player.WIDTH/2;
    }

    public double distance(double x1, double y1, double x2, double y2) {
            double ac = Math.abs(y2 - y1);
            double cb = Math.abs(x2 - x1);

            return Math.hypot(ac, cb);
    }

}