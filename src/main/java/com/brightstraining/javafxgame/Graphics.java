package com.brightstraining.javafxgame;

import com.brightstraining.javafxgame.model.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;


import javafx.scene.paint.Color;
import javafx.scene.text.Font;


import java.util.ArrayList;
import java.util.List;

public class Graphics {

    private final Canvas canvas;

    // Model-coordinates are the same as screen coordinates.
    // For games with less granular coordinates (chess, game of life)
    // this should not be the case.
    public static final double SCALING = 1d;
    public static final double HEIGHT = Model.HEIGHT * SCALING;
    public static final double WIDTH = Model.WIDTH * SCALING;

    public Graphics(Canvas canvas) {
        this.canvas = canvas;
    }

    public void draw(Model model) {

        GraphicsContext context = canvas.getGraphicsContext2D();

        for (int i = 0; i < Model.ROWS; i++) {
            for (int j = 0; j < Model.COLUMNS; j++) {
                if ((i + j) % 2 == 0) {
                    context.setFill(Color.web("AAD751"));
                } else {
                    context.setFill(Color.web("A2D149"));
                }
                context.fillRect(i * Model.SQUSIZE, j * Model.SQUSIZE, Model.SQUSIZE, Model.SQUSIZE);
            }
        }

        //draw ScoreBoard
        ScoreBoard scoreBoard = model.getScoreBoard();
        context.setFill(Color.BLACK); //color
        context.setFont(Font.font(25)); // Font und Große
        context.strokeText(scoreBoard.toString(), 20, 20); // Wo wird gestellt und String

        //draw MuteButton
        if (Music.hasVolume){
        MuteButton muteButton = model.getMutebutton();
        context.setFill(Color.BLACK);
        context.drawImage(MuteButton.icon, Model.WIDTH-50,10);
        }else {
            MuteButton muteButton2 = model.getMutebutton();
        context.setFill(Color.BLACK);
        context.drawImage(MuteButton.icon2, Model.WIDTH-50,10);}

        //draw food
        Food food = model.getFood();
        context.setFill(Color.RED);
        context.drawImage(Food.icon, food.getX() - Food.WIDTH * SCALING / 2, food.getY() - Food.HEIGHT * SCALING / 2);
        //actual hitbox for testing
        //drawFoodHitbox(context, food);

        //draw poisons
        List<Bomb> bombs = model.getPoisons();
        context.setFill(Color.BLACK);
        if (ScoreBoard.score > 0) {
            for (Bomb bomb : bombs) {
                context.drawImage(Bomb.icon, bomb.getX() - Bomb.WIDTH * SCALING / 2, bomb.getY() - Bomb.HEIGHT * SCALING / 2);
                //actual hitbos for testing
                //drawPoisonHitbox(context, bomb);
            }
        }

        // draw player
        Player player = model.getPlayer();
        context.drawImage(Player.icon, player.getX() - Player.WIDTH * SCALING / 2, player.getY() - Player.HEIGHT * SCALING / 2);
        context.setFill(Color.VIOLET);
        //Actual hitbox for testing
        //drawPlayerHitbox(context,player);

        // draw Game over
        if (Model.isGameOver){
            context.setFill(Color.RED); //color
            context.setFont(Font.font(25)); // Font und Große
            context.strokeText("Game Over\n"+
                    "Git Gud\n", Model.WIDTH/2-50, Model.HEIGHT/2-50); // Wo wird gestellt und String
        }
    }

    private static void drawFoodHitbox(GraphicsContext context, Food food) {
        context.fillOval(
                food.getX() - Food.WIDTH * SCALING / 2,
                food.getY() - Food.HEIGHT * SCALING / 2,
                Food.WIDTH,
                Food.HEIGHT
        );
    }

    private static void drawPoisonHitbox(GraphicsContext context, Bomb bomb) {
        context.fillOval(
                bomb.getX() - Bomb.WIDTH * SCALING / 2,
                bomb.getY() - Bomb.HEIGHT * SCALING / 2,
                Bomb.WIDTH,
                Bomb.HEIGHT
        );
    }

    private static void drawPlayerHitbox(GraphicsContext context, Player player) {
        context.fillOval(
                player.getX() - Player.WIDTH * SCALING / 2,
                player.getY() - Player.HEIGHT * SCALING / 2,
                Player.WIDTH,
                Player.HEIGHT
        );
    }
}
