package com.brightstraining.javafxgame.model;

import java.util.List;

public class Collision {
    private Player player;
    private List<Bomb> bombs;
    private Food food;

    private double radiusToKeepFree = Player.WIDTH*2.5;

    public Collision(Player player, List<Bomb> bombs, Food food) {
        this.player = player;
        this.bombs = bombs;
        this.food = food;
    }

    public boolean collidesWithAnything(double x,double y) {
        //collision with any poison in a radious playerwitdh*3
        for(Bomb bomb : bombs){
            if(distance(bomb.getX(), bomb.getY(),x,y) < radiusToKeepFree){
                return true;
            }
        }
        //collision with any food in a radious playerwitdh*3
        if(distance(food.getX(),food.getY(),x,y ) < radiusToKeepFree ){
            return true;
        }

        if(distance(player.getX(),player.getY(),x,y) < radiusToKeepFree){
            return true;
        }

        return false;
    }
    public boolean collidesWithAnythingButFood(double x,double y) {
        //collision with any poison in a radious playerwitdh*3
        for(Bomb bomb : bombs){
            if(distance(bomb.getX(), bomb.getY(),x,y) < radiusToKeepFree){
                return true;
            }
        }

        if(distance(player.getX(),player.getY(),x,y) < radiusToKeepFree){
            return true;
        }

        return false;
    }

    public  boolean playerCollidesWithFood(){
        //Colliding when distance between center less than sum of both radius
        return distance(food.getX(),food.getY(),player.getX(),player.getY()) < Food.WIDTH/2 + Player.WIDTH/2;
    }

    public  boolean playerCollidesWithPoison(){
        //Colliding when distance between center less than sum of both radius
        for(Bomb bomb : bombs){
            if(distance(bomb.getX(), bomb.getY(),player.getX(),player.getY()) < bomb.WIDTH/2 + Player.WIDTH/2){
                return true;
            }
        }
        return false;
    }

    public  double distance(double x1, double y1, double x2, double y2) {
        double ac = Math.abs(y2 - y1);
        double cb = Math.abs(x2 - x1);

        return Math.hypot(ac, cb);
    }
}
