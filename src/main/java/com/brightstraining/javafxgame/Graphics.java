package com.brightstraining.javafxgame;

import com.brightstraining.javafxgame.model.Food;
import com.brightstraining.javafxgame.model.Model;
import com.brightstraining.javafxgame.model.Player;
import com.brightstraining.javafxgame.model.ScoreBoard;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Graphics {

    private Canvas canvas;

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
        /**
         // draw sky
         context.setFill(Color.LIGHTBLUE);
         context.fillRect(0, 0, Graphics.WIDTH, Graphics.HEIGHT);
         */

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
        // draw floor
        context.setFill(Color.GRAY);
        context.fillRect(0, Graphics.HEIGHT - 5, Graphics.WIDTH, Graphics.HEIGHT);
        //draw ScoreBoard
        ScoreBoard scoreBoard= model.getScoreBoard ();
        context.setFill (Color.BLACK); //color
        context.setFont (Font.font (25)); // Font und Große
        context.strokeText (scoreBoard.toString (),20,20); // Wo wird gestellt und String
        //draw food
        Food food = model.getFood();
        context.setFill(Color.RED);
        context.fillOval(food.getX() - Food.WIDTH * SCALING / 2,
                food.getY() - Food.HEIGHT * SCALING / 2, Food.WIDTH, Food.HEIGHT);

        // draw player
        Player player = model.getPlayer();
        context.setFill(Color.BLUEVIOLET);
        context.fillOval(player.getX() - Player.WIDTH * SCALING / 2,
                player.getY() - Player.HEIGHT * SCALING / 2, Player.WIDTH, Player.HEIGHT);
        //context.fillPolygon(new double[] {player.getX() - Player.WIDTH * SCALING / 2}, new double[]{player.getY() -Player.HEIGHT * SCALING / 2}, (int) Player.WIDTH);

        /*context.fillOval(
                player.getX() - Player.WIDTH * SCALING / 2,
                player.getY() - Player.HEIGHT * SCALING / 2,
                Player.WIDTH,
                Player.HEIGHT
        );*/
    }
}